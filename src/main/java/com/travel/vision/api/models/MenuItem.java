package com.travel.vision.api.models;

import com.travel.vision.api.enums.FoodCategory;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "destination")
@ApiModel(description = "All details related to Destinations")
@Inheritance(strategy = InheritanceType.JOINED)
public class MenuItem {
    private String dishName;
    private FoodCategory foodCategory;
    private String description;
    private List<FoodReview> reviews;

}
