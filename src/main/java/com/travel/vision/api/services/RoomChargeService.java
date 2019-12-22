package com.travel.vision.api.services;

import com.travel.vision.api.models.restaurants.RoomCharge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface RoomChargeService {
    RoomCharge create(RoomCharge roomCharge);
    void delete(long roomChargeId);
    RoomCharge update(RoomCharge roomcharge);
    RoomCharge getOne(long roomChargeId);
    List<RoomCharge> findAll();
    List<RoomCharge> findAllByDate(LocalDateTime from, LocalDateTime to);
    Page<RoomCharge> findAllPageable(Pageable pageable);
    Page<RoomCharge> findAllByDatePageable(LocalDateTime from, LocalDateTime to, Pageable pageable);
    double calculateBillTotal(double subTotal, BigDecimal taxRate, double tipAmount);
}
