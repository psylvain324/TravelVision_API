package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Table(name = "travel_wallet")
@ApiModel(description = "All details related to Travel Wallets")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class TravelWallet extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "profile_id")
    @ApiModelProperty(notes = "The Profile Id to Join Profiles in the database")
    private Profile profile;
}
