package com.travel.vision.api.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class CurrencyLayer extends Currency {
    @Column(name = "success")
    private boolean success;
    @Column(name = "time_stamp")
    private String timestamp;
    @Column(name = "base")
    private String base;
    @Column(name = "date")
    private Date date;
    @Column(name = "rate")
    private Double rate;
}
