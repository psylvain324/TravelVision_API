package com.travel.vision.api.models;

import com.travel.vision.api.enums.Gender;
import com.travel.vision.api.enums.Status;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "profile")
@ApiModel(description = "All details related to profiles")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class Profile extends BaseModel {
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "mobile_country_code")
    private String mobileCountryCode;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "status")
    private Status status;

    @Column(name = "email_subscription")
    private boolean emailSubscription;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
