package com.travel.vision.api.services;

import com.travel.vision.api.models.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfileService {
    Page<Profile> getAllProfiles(Pageable pageable);
}
