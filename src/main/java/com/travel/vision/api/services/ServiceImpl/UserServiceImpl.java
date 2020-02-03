package com.travel.vision.api.services.ServiceImpl;

import com.travel.vision.api.models.common.User;
import com.travel.vision.api.repositories.UserRepository;
import com.travel.vision.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer userid) {
        return getAllUsers().stream()
                .filter(x -> x.getUserid()  == userid)
                .findAny()
                .orElse(new User(0, "Not Available"));
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        getAllUsers().stream()
                .filter(x -> x.getUserid()  == user.getUserid())
                .findAny()
                .orElseThrow(() -> new RuntimeException("Item not found"))
                .setUsername(user.getUsername());
    }

    @Override
    public void deleteUser(Integer userid) {
        getAllUsers().removeIf((User u) -> u.getUserid() == userid);
    }
}