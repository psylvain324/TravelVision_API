package com.travel.vision.api.models.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class FacebookAccessToken extends BaseModel {
    @Column(name = "token")
    private String token;

    public FacebookAccessToken(String facebookId,String token) {
        this.facebookId = facebookId;
        this.setToken(token);
    }

    public FacebookAccessToken() {
    }

    @Column(unique = true)
    private String facebookId;

    @OneToOne(mappedBy="facebookAccessToken")
    private Profile profile;
    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

