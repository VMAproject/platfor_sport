package com.sport.mvc.services;

import com.sport.mvc.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getUserById(Long id);

    User getUserByUsername(String username);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    boolean userExists(String username);
}
