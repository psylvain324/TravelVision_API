package com.travel.vision.api.repositories;

import com.travel.vision.api.models.financials.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {
    Flux<Payment> findAllByUser(String user);
}
