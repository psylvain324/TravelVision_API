package com.travel.vision.api.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "destination")
@ApiModel(description = "All details related to Destinations")
@Inheritance(strategy = InheritanceType.JOINED)
public class Destination extends BaseModel {

}
