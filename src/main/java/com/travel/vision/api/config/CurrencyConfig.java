package com.travel.vision.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

@Getter
@Setter
@Configuration
public class CurrencyConfig {

    @PostConstruct
    public void initIt() {
        retrieveKeyID();
    }

    private String url;

    @Value("${Configurations.Key")
    private int key;

    @Value("${Configurations.url.KeyLayer")
    private String keyLayer;

    public int retrieveKeyID() {
        return key;
    }
}
