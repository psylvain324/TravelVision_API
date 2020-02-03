package com.travel.vision.api.repositories;

import com.travel.vision.api.models.common.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>, JpaSpecificationExecutor<User> {
    User save(User user);
    Page<User> findAll(Pageable pageable);
}
