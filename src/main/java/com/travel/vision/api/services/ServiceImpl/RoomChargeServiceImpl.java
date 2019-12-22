package com.travel.vision.api.services.ServiceImpl;

import com.travel.vision.api.models.restaurants.RoomCharge;
import com.travel.vision.api.repositories.RoomChargeRepository;
import com.travel.vision.api.services.BaseService;
import com.travel.vision.api.services.RoomChargeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    public void delete(long roomChargeId) {
        RoomCharge roomCharge = getOne(roomChargeId);
        roomChargeRepository.delete(roomCharge);
    }

    @Override
    public RoomCharge update(RoomCharge roomcharge) {
        return roomChargeRepository.save(roomcharge);
    }

    @Override
    public RoomCharge getOne(long roomChargeId) {
        return findOne(RoomCharge.class, roomChargeId);
    }

    @Override
    public List<RoomCharge> findAll() {
        return roomChargeRepository.findAll();
    }

    @Override
    public List<RoomCharge> findAllByDate(LocalDateTime from, LocalDateTime to) {
        return roomChargeRepository.findAllByDateRange(from, to);
    }

    @Override
    public Page<RoomCharge> findAllPageable(Pageable pageable) {
        return roomChargeRepository.findAll(pageable);
    }

    @Override
    public Page<RoomCharge> findAllByDatePageable(LocalDateTime from, LocalDateTime to, Pageable pageable) {
        return roomChargeRepository.findAllByDateRangePageable(from, to, pageable);
    }

    @Override
    public double calculateBillTotal(double subTotal, BigDecimal taxRate, double tipAmount) {
        return (taxRate.multiply(new BigDecimal(subTotal))).doubleValue() + tipAmount;
    }

}
