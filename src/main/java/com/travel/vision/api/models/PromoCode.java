package com.travel.vision.api.models;

import com.travel.vision.api.enums.PromoType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "promo_code")
public class PromoCode extends BaseModel {
    @Column(name = "promo_code")
    private String code;

    @Column(name = "promo_type")
    @Enumerated(EnumType.STRING)
    private PromoType promoType;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
}
