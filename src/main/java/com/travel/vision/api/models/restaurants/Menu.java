package com.travel.vision.api.models.restaurants;

import com.travel.vision.api.enums.MenuType;
import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.common.BaseModel;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "menu")
@ApiModel(description = "All details related to menus")
@Inheritance(strategy = InheritanceType.JOINED)
public class Menu extends BaseModel {
    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_type")
    private MenuType menuType;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @OneToMany(
            mappedBy = "menuItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<MenuItem> menuItems;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

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
