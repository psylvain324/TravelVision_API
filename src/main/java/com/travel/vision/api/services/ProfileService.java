package com.travel.vision.api.services;

import com.travel.vision.api.models.Profile;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProfileService {
    Profile create(Profile profile);
    List<Profile> findAllActive();
    void delete(String profileId);
    Profile update(Profile profile);
    Profile getOne(String profileId);
    Profile getByEmail(String email);
    void changeStatus(String seasonId);
    void makeInactive(List<String> seasonIds);
    List<Profile> findAll(Pageable pageable);
}
