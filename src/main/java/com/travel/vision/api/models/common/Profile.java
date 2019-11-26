package com.travel.vision.api.models.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.vision.api.enums.Gender;
import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.customers.GiftCardWallet;
import com.travel.vision.api.models.customers.LoyaltyPointsWallet;
import com.travel.vision.api.models.customers.PromoCodeWallet;
import com.travel.vision.api.models.customers.TravelWallet;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "profile")
@ApiModel(description = "All details related to profiles")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public class Profile extends BaseModel {
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "mobile_country_code")
    private String mobileCountryCode;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "gender")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "status")
    private Status status;

    @Column(name = "email_subscription")
    private boolean emailSubscription;

    @Column(name = "email_verified")
    private boolean emailVerified;

    @Column(name = "stripe_id")
    private String stripeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facebook_profile_picture_id")
    private FacebookProfilePicture facebookProfilePicture;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facebook_token_id")
    @JsonIgnore
    private FacebookAccessToken facebookAccessToken;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private PromoCodeWallet promoCodeWallet;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private TravelWallet travelWallet;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private LoyaltyPointsWallet loyaltyPointsWallet;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private GiftCardWallet giftCardWallet;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileCountryCode() {
        return mobileCountryCode;
    }

    public void setMobileCountryCode(String mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isEmailSubscription() {
        return emailSubscription;
    }

    public void setEmailSubscription(boolean emailSubscription) {
        this.emailSubscription = emailSubscription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public FacebookProfilePicture getFacebookProfilePicture() {
        return facebookProfilePicture;
    }

    public void setFacebookProfilePicture(FacebookProfilePicture facebookProfilePicture) {
        this.facebookProfilePicture = facebookProfilePicture;
    }

    public FacebookAccessToken getFacebookAccessToken() {
        return facebookAccessToken;
    }

    public void setFacebookAccessToken(FacebookAccessToken facebookAccessToken) {
        this.facebookAccessToken = facebookAccessToken;
    }

    public PromoCodeWallet getPromoCodeWallet() {
        return promoCodeWallet;
    }

    public void setPromoCodeWallet(PromoCodeWallet promoCodeWallet) {
        this.promoCodeWallet = promoCodeWallet;
    }

    public TravelWallet getTravelWallet() {
        return travelWallet;
    }

    public void setTravelWallet(TravelWallet travelWallet) {
        this.travelWallet = travelWallet;
    }

    public LoyaltyPointsWallet getLoyaltyPointsWallet() {
        return loyaltyPointsWallet;
    }

    public void setLoyaltyPointsWallet(LoyaltyPointsWallet loyaltyPointsWallet) {
        this.loyaltyPointsWallet = loyaltyPointsWallet;
    }

    public GiftCardWallet getGiftCardWallet() {
        return giftCardWallet;
    }

    public void setGiftCardWallet(GiftCardWallet giftCardWallet) {
        this.giftCardWallet = giftCardWallet;
    }
}
