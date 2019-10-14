package com.travel.vision.api.models;

import com.travel.vision.api.enums.RatingType;
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
}
