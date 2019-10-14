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
@Table(name = "menu")
@ApiModel(description = "All details related to menus")
@Inheritance(strategy = InheritanceType.JOINED)
public class Menu extends BaseModel {

}
