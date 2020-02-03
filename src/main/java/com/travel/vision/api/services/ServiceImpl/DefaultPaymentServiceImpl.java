package com.travel.vision.api.services.ServiceImpl;
import java.security.Principal;

import com.travel.vision.api.models.financials.Payment;
import com.travel.vision.api.repositories.PaymentRepository;
import com.travel.vision.api.services.PaymentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DefaultPaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final WebClient client;

    public DefaultPaymentServiceImpl(PaymentRepository repository,
                                 WebClient.Builder builder) {
        paymentRepository = repository;
        client = builder.baseUrl("http://travelvision-api.financial.com/submit")
                .build();
    }

    @Override
    public Mono<String> send(Mono<Payment> payment) {
        return (Mono<String>) payment.zipWith(
                ReactiveSecurityContextHolder.getContext(),
                (p, c) -> p.withDisplayName(c.getAuthentication().getName())
        )
                .flatMap(p -> client.post()
                        .syncBody(p)
                        .retrieve()
                        .bodyToMono(String.class)
                        .then(paymentRepository.save(p)))
                .map(Payment::getId);
    }

    @Override
    public Flux<Payment> list() {
        return ReactiveSecurityContextHolder
                .getContext()
                .map(SecurityContext::getAuthentication)
                .map(Principal::getName)
                .flatMapMany(paymentRepository::findAllByUser);
    }
}