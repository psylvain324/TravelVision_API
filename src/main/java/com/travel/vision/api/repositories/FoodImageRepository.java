package com.travel.vision.api.repositories;

import com.travel.vision.api.models.FoodImage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodImageRepository extends MongoRepository<FoodImage,String>, JpaSpecificationExecutor<FoodImage> {

}

