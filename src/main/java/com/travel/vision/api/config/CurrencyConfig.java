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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getKeyLayer() {
        return keyLayer;
    }

    public void setKeyLayer(String keyLayer) {
        this.keyLayer = keyLayer;
    }
}
