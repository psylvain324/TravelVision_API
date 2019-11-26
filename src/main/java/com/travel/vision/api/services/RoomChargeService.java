package com.travel.vision.api.services;

import com.travel.vision.api.models.restaurants.RoomCharge;
import java.util.List;

public interface RoomChargeService {
    RoomCharge create(RoomCharge roomCharge);
    void delete(String roomChargeId);
    RoomCharge update(RoomCharge roomcharge);
    RoomCharge getOne(String roomChargeId);
    List<RoomCharge> findAll();
}
