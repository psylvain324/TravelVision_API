package com.travel.vision.api.models.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class FacebookProfilePicture extends BaseImage {
    @OneToOne(mappedBy="facebookProfilePicture")
    @JsonIgnore
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}