package com.travel.vision.api.models.customers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.vision.api.models.common.BaseModel;
import com.travel.vision.api.models.common.BasePromoCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "promo_wallet")
public class PromoCodeWallet extends BaseModel {
    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<BasePromoCode> promoCodes;
}
