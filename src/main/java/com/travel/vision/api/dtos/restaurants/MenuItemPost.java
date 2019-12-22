package com.travel.vision.api.dtos.restaurants;

import com.travel.vision.api.enums.FoodCategory;
import com.travel.vision.api.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Validated
public class MenuItemPost {
    private String dishName;
    private FoodCategory foodCategory;
    private String description;
    private FoodImagePost foodImagePost;
    @Enumerated(EnumType.STRING)
    private Status status;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodImagePost getFoodImagePost() {
        return foodImagePost;
    }

    public void setFoodImagePost(FoodImagePost foodImagePost) {
        this.foodImagePost = foodImagePost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
