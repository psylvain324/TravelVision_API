package com.travel.vision.api.models.common;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.*;

@Entity
@Getter
@Setter
@ApiModel(description = "All details related to countries and getting countries")
@Inheritance(strategy = InheritanceType.JOINED)
public class Country extends BaseModel {
    private String name;
    private String code;
    private String iso;

    public Country(String iso, String code, String name) {
        super();
        this.iso = iso;
        this.code = code;
        this.name = name;
    }

    private List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        String[] countryCodes = Locale.getISOCountries();

        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String iso = locale.getISO3Country();
            String code = locale.getCountry();
            String name = locale.getDisplayCountry(Locale.US);
            countries.add(new Country(iso, code, name));
        }
        countries.sort(Comparator.comparing(Country::getName));
        return countries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}
