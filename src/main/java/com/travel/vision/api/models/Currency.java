package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ApiModel(description = "All details related to Currency")
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
