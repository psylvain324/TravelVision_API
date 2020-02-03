package com.travel.vision.api.models.employees;

import com.travel.vision.api.models.common.BaseModel;
import com.travel.vision.api.models.common.Profile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "schedule")
@ApiModel(description = "All GET details related to Employee Schedules")
@Inheritance(strategy = InheritanceType.JOINED)
public class Schedule extends BaseModel {
    @OneToOne
    @JoinColumn(name = "profile_id")
    @ApiModelProperty(notes = "The Profile Id to Join Profiles in the database")
    private Profile profile;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @ApiModelProperty(notes = "The Employee Id to Join Employees in the database")
    public Employee employee;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Shift> shifts;

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
