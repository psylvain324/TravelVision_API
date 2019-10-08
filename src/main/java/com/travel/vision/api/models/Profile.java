package com.travel.vision.api.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile extends BaseModel {
    private String email;
    private String password;
}
