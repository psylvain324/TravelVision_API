package com.travel.vision.api.models.restaurants;

import com.travel.vision.api.models.common.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "food_review")
@ApiModel(description = "All details related to food reviews")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class FoodReview extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    @ApiModelProperty(notes = "The menu item id to join tables in the database")
    private MenuItem menuItem;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
