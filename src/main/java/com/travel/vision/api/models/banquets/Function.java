package com.travel.vision.api.models.banquets;

import com.travel.vision.api.enums.FunctionType;
import com.travel.vision.api.models.common.BaseModel;
import com.travel.vision.api.models.restaurants.MenuItem;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "functions")
@ApiModel(description = "All details related to functions")
@Inheritance(strategy = InheritanceType.JOINED)
public class Function extends BaseModel {
    private FunctionType functionType;
    @OneToMany(
            mappedBy = "guest",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Guest> guestList;
    @OneToMany(
            mappedBy = "menuItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MenuItem> menuItemList;
    private String functionTitle;
    private String description;
    private String instructions;

    public FunctionType getFunctionType() {
        return functionType;
    }

    public void setFunctionType(FunctionType functionType) {
        this.functionType = functionType;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public String getFunctionTitle() {
        return functionTitle;
    }

    public void setFunctionTitle(String functionTitle) {
        this.functionTitle = functionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
