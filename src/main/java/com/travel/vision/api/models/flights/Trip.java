package com.travel.vision.api.models.flights;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.vision.api.models.common.BaseModel;
import com.travel.vision.api.models.common.City;
import com.travel.vision.api.models.common.Profile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "trip")
@ApiModel(description = "All details about the Customer TripCms")
@Entity
public class Trip extends BaseModel {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ApiModelProperty(notes = "The Created Date stored in the database")
    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCreated;

    @ApiModelProperty(notes = "The Depart Date stored in the database")
    @Column(name = "depart_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date departDate;

    @ApiModelProperty(notes = "The Return Date stored in the database")
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date returnDate;

    @ApiModelProperty(notes = "The TripCms Name stored in the database")
    @Column(name = "trip_name")
    private String tripName;

    @ApiModelProperty(notes = "The Destinations stored in the database")
    @OneToMany(
            mappedBy = "trip",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<City> destinations;

    @ApiModelProperty(notes = "The Flight Number stored in the database")
    @Column(name = "flight_number")
    private String flightNumber;

    @ApiModelProperty(notes = "The Travel Period stored in the database")
    @Column(name = "travel_period")
    private String travelPeriod;
}
