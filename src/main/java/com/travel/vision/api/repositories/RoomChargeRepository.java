package com.travel.vision.api.repositories;

import com.travel.vision.api.models.restaurants.RoomCharge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomChargeRepository extends MongoRepository<RoomCharge,String>, JpaSpecificationExecutor<RoomCharge> {
    RoomCharge save(RoomCharge roomCharge);
    Page<RoomCharge> findAll(Pageable pageable);
}