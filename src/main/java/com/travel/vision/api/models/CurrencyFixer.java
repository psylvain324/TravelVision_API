package com.travel.vision.api.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class CurrencyFixer extends Currency {
    @Column(name = "success")
    private boolean success;
    @Column(name = "time_stamp")
    private String timestamp;
    @Column(name = "terms")
    private String terms;
    @Column(name = "privacy")
    private String privacy;
    @Column(name = "rate")
    private Double rate;
}
