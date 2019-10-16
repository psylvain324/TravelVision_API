package com.travel.vision.api.repositories;

import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.Menu;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuRepository extends MongoRepository<Menu,String>, JpaSpecificationExecutor<Menu> {
    Menu save(Menu menu);
    Menu getOne(String menuId);
    List<Menu> findAllByStatus(Status status);
}
