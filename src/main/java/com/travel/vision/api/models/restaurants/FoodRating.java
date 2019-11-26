package com.travel.vision.api.models.restaurants;

import com.travel.vision.api.enums.RatingType;
import com.travel.vision.api.models.common.BaseModel;
import com.travel.vision.api.models.common.Profile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food_rating")
@ApiModel(description = "All details related to Food Ratings")
@Inheritance(strategy = InheritanceType.JOINED)
public class FoodRating extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @ApiModelProperty(notes = "The Profile Id to Join Profiles in the database")
    private Profile profile;

    @OneToMany(
            mappedBy = "feature",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<RatingType> ratingTypes;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<RatingType> getRatingTypes() {
        return ratingTypes;
    }

    public void setRatingTypes(List<RatingType> ratingTypes) {
        this.ratingTypes = ratingTypes;
    }
}
