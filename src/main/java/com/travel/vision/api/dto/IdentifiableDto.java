package com.travel.vision.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class IdentifiableDto {
    @ApiModelProperty(value = "UUID of the object",required = true)
    private String id;
}