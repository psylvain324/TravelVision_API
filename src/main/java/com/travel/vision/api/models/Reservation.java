package com.travel.vision.api.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.vision.api.enums.ReservationStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "reservations")
@ApiModel(description = "All GET details related to Reservations")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reservation extends BaseModel {

    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "")
    @Column(name = "reservation_id")
    private long reservationId;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @ApiModelProperty(notes = "The Profile Id to Join Profiles in the database")
    private Profile profile;

    @ApiModelProperty(notes = "The Reservation Name stored in the database")
    @Column(name = "reservation_name")
    private String reservationName;

    @ApiModelProperty(notes = "The Reservation Time stored in the database")
    @Column(name = "reservation_time")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH-MM")
    private Time reservationTime;

    @ApiModelProperty(notes = "The Party Size stored in the database")
    @Column(name = "party_size")
    private int partySize;

    @ApiModelProperty(notes = "The reservation status stored in the database")
    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status")
    private ReservationStatus status = ReservationStatus.Pending;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public Time getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Time reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
