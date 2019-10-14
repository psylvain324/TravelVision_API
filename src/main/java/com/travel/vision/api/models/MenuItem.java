package com.travel.vision.api.models;

import com.travel.vision.api.enums.FoodCategory;
import com.travel.vision.api.enums.Status;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "menu_item")
@ApiModel(description = "All details related to Destinations")
@Inheritance(strategy = InheritanceType.JOINED)
public class MenuItem {
    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "food_category")
    private FoodCategory foodCategory;

    @Column(name = "description")
    private String description;

    @Column(name = "reviews")
    private List<FoodReview> reviews;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
