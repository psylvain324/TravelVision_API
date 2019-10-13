package com.travel.vision.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Table(name = "schedule")
@ApiModel(description = "All GET details related to Travel Wallets")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class Schedule extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "profile_id")
    @ApiModelProperty(notes = "The Profile Id to Join Profiles in the database")
    private Profile profile;

}
