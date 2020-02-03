package com.travel.vision.api.services;

import com.travel.vision.api.models.common.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Integer userid);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userid);
}

