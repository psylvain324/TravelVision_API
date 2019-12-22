package com.travel.vision.api.dtos.restaurants;

import com.travel.vision.api.dtos.AuditableDto;
import com.travel.vision.api.enums.MenuType;
import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.restaurants.MenuItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Validated
public class MenuGet extends AuditableDto {
    private String menuName;
    private MenuType menuType;
    private Time startTime;
    private Time endTime;
    @OneToMany(
            mappedBy = "menuItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<MenuItem> menuItems;
    @Enumerated(EnumType.STRING)
    private Status status;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
