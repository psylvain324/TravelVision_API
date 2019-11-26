package com.travel.vision.api.dto.restaurants;

import com.travel.vision.api.dto.IdentifiableDto;
import com.travel.vision.api.enums.MenuType;
import com.travel.vision.api.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Time;

@Getter
@Setter
@Validated
public class MenuPatch extends IdentifiableDto {
    private String menuName;
    private MenuType menuType;
    private Time startTime;
    private Time endTime;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
