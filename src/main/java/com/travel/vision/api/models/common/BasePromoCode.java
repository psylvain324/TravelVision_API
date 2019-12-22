package com.travel.vision.api.models.common;

import com.travel.vision.api.enums.PromoType;
import com.travel.vision.api.models.common.BaseModel;
import org.joda.time.DateTime;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "promo_code")
public class BasePromoCode extends BaseModel {
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
    private DateTime startTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private DateTime endTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PromoType getPromoType() {
        return promoType;
    }

    public void setPromoType(PromoType promoType) {
        this.promoType = promoType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }
}
