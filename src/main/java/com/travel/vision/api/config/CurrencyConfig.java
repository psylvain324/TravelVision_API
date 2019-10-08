package com.travel.vision.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

@RestController
public class CurrencyConfig {

    @PostConstruct
    public void initIt() {
        retrieveKeyID();
        retrieveURL();
    }

    @Getter
    @Setter
    private String url;

    @Value("${Configurations.Key")
    private int key;

    @Value("${Configurations.url.KeyLayer")
    private String keyLayer;

    @Value("${Configurations.url.KeyFixer ")
    private String keyFixer;

    @GetMapping("/Configurations/key")
    public int retrieveKeyID() {
        return key;
    }

    @GetMapping("/Configurations/url")
    public String retrieveURL() {
        if (key == 1 ){
            url = keyLayer;
            if(key == 2){
                url = keyFixer;
            }
        }
        return url;
    }
}
