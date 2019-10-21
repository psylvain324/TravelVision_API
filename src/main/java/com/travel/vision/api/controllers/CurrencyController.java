package com.travel.vision.api.controllers;

import com.travel.vision.api.services.CurrencyService;
import com.travel.vision.api.utilities.ResponseDtoConverter;
import com.travel.vision.api.utilities.TvResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Currency Controller"})
@RestController
@RequestMapping( value = "/api/currency/")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @ApiOperation("Get list of all Menu records")
    @GetMapping("/quotes/{from}/{to}")
    public TvResponse<Double> getCurrencyQuote(@PathVariable String from, @RequestParam String to){
        return ResponseDtoConverter.convert(currencyService.getCurrencyQuote(from, to));
    }
}
