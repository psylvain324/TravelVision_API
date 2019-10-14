package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "service_review")
@ApiModel(description = "All details related to service reviews")
@Inheritance(strategy = InheritanceType.JOINED)
public class ServiceReview extends BaseModel {
    @OneToOne
    @JoinColumn(name = "employee_id")
    @ApiModelProperty(notes = "The Employee Id to Join Employees in the database")
    public Employee employee;

    @Column(name = "service_description")
    public String serviceDescription;

    @Column(name = "food_description")
    public String foodDescription;

    @Column(name = "service_rating")
    public int serviceRating;

    @Column(name = "food_rating")
    public int foodRating;

    @Column(name = "overall_rating")
    public int overallRating;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public int getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(int serviceRating) {
        this.serviceRating = serviceRating;
    }

    public int getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(int foodRating) {
        this.foodRating = foodRating;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }
}
