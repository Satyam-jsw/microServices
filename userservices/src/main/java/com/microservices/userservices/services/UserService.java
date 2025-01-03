package com.microservices.userservices.services;


import com.microservices.userservices.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String id);

    void deleteUser(String id);

    User updateUser(String id, User user);

}
