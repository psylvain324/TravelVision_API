package com.travel.vision.api.dao.restaurants;

import com.travel.vision.api.models.restaurants.RoomCharge;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

//TODO: Add Missing Fields
public class RoomChargeSpringDao implements RoomChargeDao {
    private final JdbcTemplate jdbcTemplate;

    public RoomChargeSpringDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(RoomCharge roomCharge) {
        int rowCount = jdbcTemplate.update("INSERT INTO RoomCharge VALUES (?,?,?)",
            new Object[] {
                    roomCharge.getId(),
                    roomCharge.getRoomNumber(),
                    roomCharge.getLastName()
            });
        return rowCount == 1;
    }

    @Override
    public boolean update(RoomCharge roomCharge) {
        return jdbcTemplate.update("UPDATE RoomCharge SET room_number=?, last_name=? WHERE id=?",
            new Object[] {
                    roomCharge.getRoomNumber(),
                    roomCharge.getLastName(),
                    roomCharge.getId()
        }) == 1;
    }

    @Override
    public List<RoomCharge> searchById(long id) {
        return jdbcTemplate.query("SELECT * FROM RoomCharge where id=?", new Object[] { id}, new RoomChargeRowMapper());
    }

    @Override
    public List<RoomCharge> searchByRoomNumber(String roomNumber) {
        return jdbcTemplate.query("SELECT * FROM RoomCharge where room_number=?", new Object[] { roomNumber}, new RoomChargeRowMapper());
    }

    @Override
    public List<RoomCharge> searchByLastName(String lastName) {
        return jdbcTemplate.query("SELECT * FROM RoomCharge where last_name=?", new Object[] { lastName}, new RoomChargeRowMapper());
    }

    @Override
    public boolean delete(long id) {
        return jdbcTemplate.update("DELETE FROM RoomCharge WHERE id=?",
                new Object[] { id}) > 0;
    }

}

