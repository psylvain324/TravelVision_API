package com.travel.vision.api.services.ServiceImpl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.travel.vision.api.exceptions.CustomException;
import com.travel.vision.api.exceptions.MessageKey;
import com.travel.vision.api.services.BaseService;
import com.travel.vision.api.services.StripeService;
import okhttp3.internal.http2.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeServiceImpl extends BaseService implements StripeService {
    @Value("${stripe.skey}")
    private String stripeSecretKey;
    private static final Logger log = LoggerFactory.getLogger(StripeServiceImpl.class);

    public StripeServiceImpl() {
    }

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }

    @Override
    public Customer createCustomer(String sourceToken, String description) {
        Map<String, Object> customerParams = new HashMap<>();
        customerParams.put("description", description);
        customerParams.put("source", sourceToken);
        try {
            return Customer.create(customerParams);
        } catch (StripeException e) {
            log.error("error during stripe processing", e);
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.error_third_party_api);
        }
    }

    @Override
    public Customer updateCustomer(String customerId, String orderId) {
        try {
            Customer customer = Customer.retrieve(customerId);
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("order_id", orderId);
            Map<String, Object> params = new HashMap<>();
            params.put("metadata", metadata);
            return customer.update(params);
        } catch (StripeException e) {
            log.error("error during stripe processing", e);
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.error_third_party_api);
        }
    }

    @Override
    public ExternalAccount retrieveCard(String customerId) {
        try {
            return Customer.retrieve(customerId).getSources().retrieve(customerId);
        } catch (StripeException e) {
            log.error("error during stripe processing", e);
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.error_third_party_api);
        }
    }

    @Override
    public ExternalAccountCollection retrieveAllCards(String customerId) {
        try {
            Map<String, Object> cardParams = new HashMap<>();
            cardParams.put("limit", 3);
            cardParams.put("object", "card");
            return Customer.retrieve(customerId).getSources().list(cardParams);
        }
        catch (StripeException e) {
            log.error("error during stripe processing", e);
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.error_third_party_api);
        }
    }

    @Override
    public void createCard(String source, String customerId, String tokenId) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put(source, tokenId);
            Customer.retrieve(customerId).getSources().create(params);
        } catch (StripeException e) {
            log.error("error during stripe processing", e);
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.error_third_party_api);
        }
    }

    @Override
    public void deleteCard(String customerId, String cardId) {
        try {
            Customer customer = Customer.retrieve(customerId);
            Card card = (Card) customer.getSources().retrieve(cardId);
            card.delete();
        } catch (StripeException e) {
            log.error("error during stripe processing", e);
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.error_third_party_api);
        }
    }

    @Override
    public Charge chargeCustomer(long amount, String currency, String customerId) {
        Map<String, Object> customerParams = new HashMap<>();
        customerParams.put("amount", amount);
        customerParams.put("currency", currency);
        customerParams.put("customer", customerId);
        try {
            return Charge.create(customerParams);
        } catch (StripeException e) {
            log.error("error during stripe processing", e);
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.error_third_party_api);
        }
    }
}
