package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table(name = "country")
@ApiModel(description = "All details related to Country")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class Country extends BaseModel {

}
