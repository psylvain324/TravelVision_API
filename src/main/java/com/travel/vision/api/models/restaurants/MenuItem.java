package com.travel.vision.api.models.restaurants;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "food_category")
    private FoodCategory foodCategory;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(
            mappedBy = "menuItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FoodReview> reviews;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

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
