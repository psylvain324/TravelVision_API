package com.travel.vision.api.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "currency")
public class Currency extends BaseModel {
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "base_name")
    private String baseName;
    @Column(name = "value")
    private Double value;
}
