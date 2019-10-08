package com.travel.vision.api.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "travel_wallet")
public class TravelWallet extends BaseModel {

}
