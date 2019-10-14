package com.travel.vision.api.controllers;

import com.stripe.model.*;
import com.travel.vision.api.services.StripeService;
import com.travel.vision.api.utilities.ResponseDtoConverter;
import com.travel.vision.api.utilities.TvResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Stripe Controller"})
@RestController
@RequestMapping( value = "/api/stripe/")
public class StripeController {

    @Autowired
    private final StripeService stripeService;

    public StripeController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @ApiOperation("Create a new Stripe Card for Customer")
    @PostMapping(value = "/create")
    public TvResponse<String> createCard(@RequestBody String source, @RequestParam String customerId, @RequestParam String tokenId) {
        stripeService.createCard(source, customerId, tokenId);
        return ResponseDtoConverter.convert(Message.CARD_ADDED);
    }

    @ApiOperation("Create a new Customer to store Stripe Card Info to")
    @PostMapping(value = "/customer/create")
    public TvResponse<Customer> createCustomer(@RequestParam String sourceToken, @RequestParam String description) {
        return ResponseDtoConverter.convert(stripeService.createCustomer(sourceToken, description));
    }

    @ApiOperation("Update a Customer")
    @PostMapping(value = "/customer/update")
    public TvResponse<Customer> updateCustomer(@RequestParam String orderId, @RequestParam String customerId) {
        return ResponseDtoConverter.convert(stripeService.updateCustomer(customerId, orderId));
    }

    @ApiOperation("Charge a Customer through Stripe API")
    @PostMapping(value = "/customer/{customerId}/charge")
    public TvResponse<Charge> chargeCustomer(@RequestParam long amount, @RequestParam String currency, @PathVariable String customerId) {
        return ResponseDtoConverter.convert(stripeService.chargeCustomer(amount, currency, customerId));
    }

    @ApiOperation("Get All Stripe Cards by Customer Id")
    @GetMapping(value = "/customer/{customerId}/all-cards")
    public TvResponse<ExternalAccountCollection> getAllCardsByCustomerId(@PathVariable String customerId) {
        return ResponseDtoConverter.convert(stripeService.retrieveAllCards(customerId));
    }

    @ApiOperation("Get a Stripe Card by Customer Id")
    @GetMapping(value = "/customer/card/{customerId}")
    public TvResponse<ExternalAccount> getCardByCustomerId(@PathVariable String customerId) {
        return ResponseDtoConverter.convert(stripeService.retrieveCard(customerId));
    }

    @ApiOperation("Delete a a Stripe Card for Customer")
    @PostMapping(value = "/delete/{cardId}")
    public TvResponse<String> deleteCard(@PathVariable String cardId, @RequestParam String customerId) {
        stripeService.deleteCard(cardId, customerId);
        return ResponseDtoConverter.convert(Message.CARD_DELETED);
    }

    private static class Message {
        private final static String CARD_ADDED = "Card added successfully";
        private final static String CARD_DELETED = "Card deleted successfully";
    }
}