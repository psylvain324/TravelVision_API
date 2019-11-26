package com.travel.vision.api.models.common;

import com.travel.vision.api.models.flights.Trip;

import javax.persistence.*;
import java.util.List;

@Entity
public class City extends BaseModel {
    private String name;
    private double latitude;
    private double longitude;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(
            mappedBy = "trip",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Trip> trips;

    public City() {
    }

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}