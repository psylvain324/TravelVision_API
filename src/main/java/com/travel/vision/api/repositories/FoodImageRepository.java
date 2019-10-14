package com.travel.vision.api.repositories;

import com.travel.vision.api.models.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodImageRepository extends JpaRepository<FoodImage,String>, JpaSpecificationExecutor<FoodImage> {

}

