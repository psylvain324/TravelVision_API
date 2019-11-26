package com.travel.vision.api.services.ServiceImpl;

import com.travel.vision.api.models.restaurants.RoomCharge;
import com.travel.vision.api.repositories.RoomChargeRepository;
import com.travel.vision.api.services.BaseService;
import com.travel.vision.api.services.RoomChargeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomChargeServiceImpl extends BaseService implements RoomChargeService {
    private final RoomChargeRepository roomChargeRepository;

    public RoomChargeServiceImpl(RoomChargeRepository roomChargeRepository) {
        this.roomChargeRepository = roomChargeRepository;
    }

    @Override
    public RoomCharge create(RoomCharge roomCharge) {
        return roomChargeRepository.save(roomCharge);
    }

    @Override
    public void delete(String roomChargeId) {
        RoomCharge roomCharge = getOne(roomChargeId);
        roomChargeRepository.delete(roomCharge);
    }

    @Override
    public RoomCharge update(RoomCharge roomcharge) {
        return roomChargeRepository.save(roomcharge);
    }

    @Override
    public RoomCharge getOne(String roomChargeId) {
        return findOne(RoomCharge.class, roomChargeId);
    }

    @Override
    public List<RoomCharge> findAll() {
        return roomChargeRepository.findAll();
    }
}
