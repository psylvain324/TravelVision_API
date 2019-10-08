package com.travel.vision.api.controllers;

import com.travel.vision.api.models.Profile;
import com.travel.vision.api.services.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/profile")
@Api(value = "User Profile API")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @ApiOperation(value = "Create a new Profile record")
    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public @ResponseBody
    void createProfile (@RequestParam int userId, @RequestParam String name, @RequestParam String password) {
        //profileService.addUser(userId);
    }

    @ApiOperation(value = "Update an already created User")
    @RequestMapping(value = "/update/", method = RequestMethod.GET)
    public @ResponseBody
    void updateProfile (@RequestParam int userId, @RequestParam String name, @RequestParam String password) {
        //profileService.updateUser(userId);
    }

    @ApiOperation(value = "Get all Users stored in the database")
    @RequestMapping(value = "/getUserByName/", method = RequestMethod.GET)
    public @ResponseBody
    String getAllProfiles(@RequestParam String userName) {
        return "";
    }

    @ApiOperation(value = "Get User stored in the database by name")
    @RequestMapping(value = "/getAll/", method = RequestMethod.GET)
    public @ResponseBody String getUserByName() {
        return "";
    }


    @ApiOperation(value = "Delete a User by Id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteUser (@RequestParam int profileId) {
        return "";
    }

}
