package com.travel.vision.api.services;

import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.ExternalAccount;
import com.stripe.model.ExternalAccountCollection;

public interface StripeService {
    Charge chargeCustomer(long amount, String currency, String customerId);
    Customer createCustomer(String sourceToken, String email);
    Customer updateCustomer(String customerId, String orderId);
    void createCard(String source, String customerId, String tokenId);
    ExternalAccount retrieveCard(String id);
    ExternalAccountCollection retrieveAllCards(String customerId);
    void deleteCard(String customerId, String cardId);
}
