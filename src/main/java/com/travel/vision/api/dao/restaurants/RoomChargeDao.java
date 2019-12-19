package com.travel.vision.api.dao.restaurants;

import com.travel.vision.api.models.restaurants.RoomCharge;
import java.util.List;

public interface RoomChargeDao {
    boolean create(RoomCharge roomCharge);
    boolean update(RoomCharge roomCharge);
    List<RoomCharge> searchById(long id);
    List<RoomCharge> searchByRoomNumber(String roomNumber);
    List<RoomCharge> searchByLastName(String lastName);
    boolean delete(long id);
}