package com.travel.vision.api.models;

import com.travel.vision.api.enums.Gender;
import com.travel.vision.api.enums.Status;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile extends BaseModel {
    private String email;
    private String password;
    private String mobileNumber;
    private String mobileCountryCode;
    private LocalDate birthDate;
    private Gender gender;
    private Status status;
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
