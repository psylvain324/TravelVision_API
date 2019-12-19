package com.travel.vision.api.services;

import com.travel.vision.api.models.common.Profile;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProfileService {
    Profile create(Profile profile);
    List<Profile> findAllActive();
    void delete(long profileId);
    Profile update(Profile profile);
    Profile getOne(long profileId);
    Profile getByEmail(String email);
    void changeStatus(long profileId);
    void makeInactive(List<Long> profileIds);
    List<Profile> findAll(Pageable pageable);
}
