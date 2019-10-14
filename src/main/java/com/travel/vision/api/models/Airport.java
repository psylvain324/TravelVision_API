package com.travel.vision.api.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ApiModel(description = "All details related to airports")
public class Airport extends BaseModel {
    private String code;
    private Double lat;
    private Double lon;
    private String name;
    private String city;
    private String state;
    private String country;
    private long woeid;
    private String tz;
    private String type;
    private long runway_length;
    private long elev;
    private String icao;
    private long direct_flights;
    private long carriers;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getWoeid() {
        return woeid;
    }

    public void setWoeid(long woeid) {
        this.woeid = woeid;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getRunway_length() {
        return runway_length;
    }

    public void setRunway_length(long runway_length) {
        this.runway_length = runway_length;
    }

    public long getElev() {
        return elev;
    }

    public void setElev(long elev) {
        this.elev = elev;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public long getDirect_flights() {
        return direct_flights;
    }

    public void setDirect_flights(long direct_flights) {
        this.direct_flights = direct_flights;
    }

    public long getCarriers() {
        return carriers;
    }

    public void setCarriers(long carriers) {
        this.carriers = carriers;
    }
}
