package com.travel.vision.api.models.financials;

import com.travel.vision.api.models.common.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Payment {
    @Id
    private String id;
    private User user;
    private String displayName;

    public Payment() {

    }

    public Payment(String id, User user, String displayName) {
        this.id = id;
        this.user = user;
    }

    public Payment withUser(User user) {
        return this.user.equals(user) ? this : new Payment(this.id, user, this.displayName);
    }

    public Payment withDisplayName(String displayName) {
        return this.displayName.equals(displayName) ? this : new Payment(this.id, this.user, displayName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

