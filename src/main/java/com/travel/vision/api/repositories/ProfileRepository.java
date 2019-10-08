package com.travel.vision.api.repositories;

import com.travel.vision.api.enums.Status;
import com.travel.vision.api.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,String>, JpaSpecificationExecutor<Profile> {
    Profile save(Profile profile);
    Profile findByEmail(String email);
    List<Profile> findAllByStatus(Status status);
}
