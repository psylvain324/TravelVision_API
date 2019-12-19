package com.travel.vision.api.services;

import com.travel.vision.api.models.restaurants.RoomCharge;
import java.math.BigDecimal;
import java.util.List;

public interface RoomChargeService {
    RoomCharge create(RoomCharge roomCharge);
    void delete(long roomChargeId);
    RoomCharge update(RoomCharge roomcharge);
    RoomCharge getOne(long roomChargeId);
    List<RoomCharge> findAll();
    double calculateBillTotal(double subTotal, BigDecimal taxRate, double tipAmount);
}
