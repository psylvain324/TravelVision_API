package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "service_review")
@ApiModel(description = "All details related to service reviews")
@Inheritance(strategy = InheritanceType.JOINED)
public class ServiceReview extends BaseModel {

}
