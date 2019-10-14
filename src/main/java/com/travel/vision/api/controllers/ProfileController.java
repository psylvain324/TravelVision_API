package com.travel.vision.api.controllers;

import com.travel.vision.api.models.Profile;
import com.travel.vision.api.services.ProfileService;
import com.travel.vision.api.utilities.ResponseDtoConverter;
import com.travel.vision.api.utilities.TvResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/admin/profile")
@Api(value = "User Profile API")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @ApiOperation(value = "Create a new Profile record")
    @PostMapping(value = "/create/")
    public TvResponse<String> createProfile (@Valid @RequestBody Profile profile) {
        profileService.create(profile);
        return ResponseDtoConverter.convert(Message.PROFILE_ADDED);
    }

    @ApiOperation(value = "Update an already created User")
    @RequestMapping(value = "/update/", method = RequestMethod.GET)
    public TvResponse<String> updatedProfile (@Valid @RequestBody Profile profile) {
        profileService.update(profile);
        return ResponseDtoConverter.convert(Message.PROFILE_UPDATED);
    }

    @ApiOperation(value = "Delete a User by Id")
    @DeleteMapping(value = "/delete/{profileId}")
    public TvResponse<String> deleteProfile(@PathVariable("profileId") String profileId) {
        profileService.delete(profileId);
        return ResponseDtoConverter.convert(Message.PROFILE_DELETED);
    }

    @ApiOperation(value = "Get List of Profile records")
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public TvResponse<List<Profile>> getAllProfiles(Pageable pageable) {
        return ResponseDtoConverter.convert(profileService.findAll(pageable));
    }

    @ApiOperation(value = "Get List of Active Profile records")
    @RequestMapping(value = "/profiles/active", method = RequestMethod.GET)
    public TvResponse<List<Profile>> getActiveProfiles(Pageable pageable) {
        return ResponseDtoConverter.convert(profileService.findAllActive());
    }

    @ApiOperation(value = "Get a single Profile record by Id")
    @GetMapping(value = "/profiles/{profileId}")
    public TvResponse<Profile> getOneProfile(@PathVariable String profileId) {
        return ResponseDtoConverter.convert(profileService.getOne(profileId));
    }

    @ApiOperation(value = "Get Profile stored in the database by email")
    @RequestMapping(value = "/get-by-email", method = RequestMethod.GET)
    public TvResponse<Profile> getProfileByEmail(@RequestParam String email) {
        return ResponseDtoConverter.convert(profileService.getByEmail(email));
    }

    @ApiOperation("Change Profile status")
    @PatchMapping("/features/change-status/{featureId}")
    public TvResponse<String> changeProfileStatus(@PathVariable("profileId") String profileId) {
        profileService.changeStatus(profileId);
        return ResponseDtoConverter.convert(Message.STATUS_CHANGED);
    }

    private static class Message {
        private final static String PROFILE_ADDED = "Profile added successfully";
        private final static String PROFILE_UPDATED = "Profile updated successfully";
        private final static String PROFILE_DELETED = "Profile deleted successfully";
        private final static String STATUS_CHANGED = "Status changed successfully";
    }

}
