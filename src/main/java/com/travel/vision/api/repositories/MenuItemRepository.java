package com.travel.vision.api.repositories;

import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.restaurants.MenuItem;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuItemRepository extends MongoRepository<MenuItem,String>, JpaSpecificationExecutor<MenuItem> {
    MenuItem save(MenuItem menuItem);
    List<MenuItem> findAllByStatus(Status status);
}
