package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import javax.persistence.*;
import java.util.Date;

@Table(name = "currency_layer")
@ApiModel(description = "All details related to Currency Layer Data")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
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
