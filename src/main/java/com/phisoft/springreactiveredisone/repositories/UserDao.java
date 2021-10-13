package com.phisoft.springreactiveredisone.repositories;

import com.phisoft.springreactiveredisone.models.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);
    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    boolean deleteUserById(Long id);

    boolean updateUserById(Long id);
}
