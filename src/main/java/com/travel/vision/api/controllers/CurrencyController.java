package com.travel.vision.api.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Currency Controller"}, description = "Currency Controller")
@RestController
@RequestMapping( value = "/api/currency/")
public class CurrencyController {

}
