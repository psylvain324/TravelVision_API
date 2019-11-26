package com.travel.vision.api.models.common;

import com.travel.vision.api.models.common.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "loyalty_points")
public class LoyaltyPoints extends BaseModel {
    private int points;

}
