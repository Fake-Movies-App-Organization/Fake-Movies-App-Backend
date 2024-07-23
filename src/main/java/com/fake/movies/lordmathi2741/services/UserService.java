package com.fake.movies.lordmathi2741.services;

import com.fake.movies.lordmathi2741.dtos.UserDTO;
import com.fake.movies.lordmathi2741.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> addUser(UserDTO userDTO);
    Optional<User> getUserById(String id);
    Optional<User> updateUser(String id, UserDTO userDTO);
    Optional<User> updateUserRole(String id, String role);
    void deleteUser(String id);
    List<User> getAllUsers();
}
