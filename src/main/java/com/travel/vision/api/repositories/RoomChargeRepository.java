package com.travel.vision.api.repositories;

import com.travel.vision.api.models.restaurants.RoomCharge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomChargeRepository extends MongoRepository<RoomCharge,String>, JpaSpecificationExecutor<RoomCharge> {
    RoomCharge save(RoomCharge roomCharge);
    Page<RoomCharge> findAllPageable(Pageable pageable);
    @Query(value = "SELECT * FROM RoomCharge BETWEEN :from AND :to ORDER BY id")
    List<RoomCharge> findAllByDateRange(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
    @Query(
            value = "SELECT * FROM RoomCharge BETWEEN :from AND :to ORDER BY id",
            countQuery = "SELECT count(*) FROM RoomCharge BETWEEN :from AND :to",
            nativeQuery = true)
    Page<RoomCharge> findAllByDateRangePageable(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to, Pageable pageable);
}