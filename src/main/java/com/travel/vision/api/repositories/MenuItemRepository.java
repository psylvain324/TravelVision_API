package com.travel.vision.api.repositories;

import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,String>, JpaSpecificationExecutor<MenuItem> {
    MenuItem save(MenuItem menuItem);
    List<MenuItem> findAllByStatus(Status status);
}
