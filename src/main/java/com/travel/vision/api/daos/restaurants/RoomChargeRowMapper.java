package com.travel.vision.api.daos.restaurants;

import com.travel.vision.api.models.restaurants.RoomCharge;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Add Missing Fields
public class RoomChargeRowMapper implements RowMapper<RoomCharge> {

    @Override
    public RoomCharge mapRow(ResultSet resultSet, int index) throws SQLException {
        RoomCharge roomCharge = new RoomCharge();
        roomCharge.setId(resultSet.getLong("id"));
        roomCharge.setRoomNumber(resultSet.getInt("room_number"));
        roomCharge.setLastName(resultSet.getString("last_name"));
        return roomCharge;
    }

}
