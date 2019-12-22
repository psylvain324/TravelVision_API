package com.travel.vision.api.models.restaurants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.travel.vision.api.models.common.BaseModel;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "room_charge")
@ApiModel(description = "All GET details related to Travel Wallets")
@Inheritance(strategy = InheritanceType.JOINED)
public class RoomCharge extends BaseModel {
    @NotNull
    @Column(name = "room_number")
    private int roomNumber;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "email_receipt")
    private boolean emailReceipt;

    @NotNull
    @Column(name = "bill_amount")
    private double billAmount;

    @Column(precision = 5, scale = 2)
    private BigDecimal taxRate;

    @NotNull
    @Column(name = "tax_amount")
    private double taxAmount;

    @NotNull
    @Column(name = "tip_amount")
    private double tipAmount;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "charge_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime chargeDate;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public boolean isEmailReceipt() {
        return emailReceipt;
    }

    public void setEmailReceipt(boolean emailReceipt) {
        this.emailReceipt = emailReceipt;
    }

    public LocalDateTime getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDateTime chargeDate) {
        this.chargeDate = chargeDate;
    }
}
