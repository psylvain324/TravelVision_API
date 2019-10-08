package com.travel.vision.api.services.ServiceImpl;

import com.travel.vision.api.models.Profile;
import com.travel.vision.api.repositories.ProfileRepository;
import com.travel.vision.api.services.BaseService;
import com.travel.vision.api.services.ProfileService;
import org.springframework.data.domain.Pageable;
import com.travel.vision.api.enums.Status;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl extends BaseService implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(String profileId) {
        Profile profile = findOne(Profile.class, profileId);
        profileRepository.delete(profile);
    }

    @Override
    public List<Profile> findAll(Pageable pageable) {
        return profileRepository.findAll();
    }

    @Override
    public List<Profile> findAllActive() {
        return profileRepository.findAllByStatus(Status.Active).stream().collect(Collectors.toList());
    }

    @Override
    public Profile getOne(String profileId) {
        return findOne(Profile.class, profileId);
    }

    @Override
    public Profile getByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    @Override
    public void changeStatus(String profileId) {
        Profile profile = getOne(profileId);
        if (profile.getStatus() == Status.Active) {
            profile.setStatus(Status.Inactive);
        } else {
            profile.setStatus(Status.Active);
        }

        profileRepository.save(profile);
    }

    @Override
    public void makeInactive(List<String> profileIds) {
        List<Profile> profiles = new ArrayList<>();
        profileIds.forEach(t -> {
            Profile profile = getOne(t);
            profile.setStatus(Status.Inactive);
            profiles.add(profile);
        });
        profileRepository.saveAll(profiles);
    }

}
