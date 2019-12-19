package com.travel.vision.api.dto.restaurants;

import com.travel.vision.api.dto.AuditableDto;
import com.travel.vision.api.enums.FoodCategory;
import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.restaurants.FoodReview;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@Validated
public class MenuItemGet extends AuditableDto {
    private String dishName;
    private FoodCategory foodCategory;
    private String description;
    private List<FoodReview> reviews;
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

    public List<FoodReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<FoodReview> reviews) {
        this.reviews = reviews;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
