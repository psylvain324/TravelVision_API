package com.travel.vision.api.models.customers;

import com.travel.vision.api.models.common.BaseModel;
import com.travel.vision.api.models.common.Profile;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
