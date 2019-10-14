package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Table(name = "schedule")
@ApiModel(description = "All GET details related to Travel Wallets")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class Schedule extends BaseModel {
    @OneToOne
    @JoinColumn(name = "profile_id")
    @ApiModelProperty(notes = "The Profile Id to Join Profiles in the database")
    private Profile profile;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @ApiModelProperty(notes = "The Employee Id to Join Employees in the database")
    public Employee employee;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
