package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table(name = "airport")
@ApiModel(description = "All details related to Airports")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class Airport extends BaseModel {

}
