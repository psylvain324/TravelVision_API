package com.travel.vision.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "promo_wallet")
public class PromoWallet extends BaseModel {
    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<PromoCode> passwordHistories;
}
