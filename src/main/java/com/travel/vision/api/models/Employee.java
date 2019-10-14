package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "employees")
@ApiModel(description = "All details related to employees")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends BaseModel {
    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "city")
    private String City;

    @Column(name = "state")
    private String State;

    @Column(name = "country")
    private String Country;

    @Column(name = "zip")
    private String Zip;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "email")
    private String Email;
}
