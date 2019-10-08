package com.travel.vision.api.utilities;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import com.travel.vision.api.models.Profile;
import com.travel.vision.api.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UsersConnectionRepository usersConnectionRepository;

    @Override
    public String execute(Connection<?> connection) {
        Profile profile = new Profile();

        ConnectionRepository cr = usersConnectionRepository.createConnectionRepository(connection.fetchUserProfile().getEmail());
        cr.addConnection(connection);

        profile.setPassword(randomAlphabetic(8));
        profileRepository.save(profile);
        return profile.getEmail();
    }
}