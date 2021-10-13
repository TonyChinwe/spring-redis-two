package com.phisoft.springreactiveredisone.services;

import com.phisoft.springreactiveredisone.models.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    boolean deleteUserById(Long id);

    boolean updateUserById(Long id);
}
