package com.travel.vision.api.dto;

import com.travel.vision.api.enums.FoodCategory;
import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.FoodReview;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@Validated
public class MenuItemPost {
    private String dishName;
    private FoodCategory foodCategory;
    private String description;
    private List<FoodReview> reviews;
    @Enumerated(EnumType.STRING)
    private Status status;
}
