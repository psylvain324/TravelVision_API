package com.travel.vision.api.repositories;

import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.common.Profile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfileRepository extends MongoRepository<Profile,String>, JpaSpecificationExecutor<Profile> {
    Profile save(Profile profile);
    Profile findByEmail(String email);
    List<Profile> findAllByStatus(Status status);
}
