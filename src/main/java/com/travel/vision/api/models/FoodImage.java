package com.travel.vision.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.vision.api.enums.DeviceType;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class FoodImage extends BaseModel {
    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id")
    @JsonIgnore
    private MenuItem menuItem;

    public void setUrl(String url) {
        this.url = url;
    }
}

