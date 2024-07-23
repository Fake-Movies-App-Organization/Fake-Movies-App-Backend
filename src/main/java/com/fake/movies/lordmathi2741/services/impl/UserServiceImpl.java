package com.fake.movies.lordmathi2741.services.impl;

import com.fake.movies.lordmathi2741.dtos.UserDTO;
import com.fake.movies.lordmathi2741.exceptions.InvalidEmailOrPassWordException;
import com.fake.movies.lordmathi2741.exceptions.InvalidUserRoleException;
import com.fake.movies.lordmathi2741.exceptions.UserAlreadyExistsException;
import com.fake.movies.lordmathi2741.exceptions.UserNotFoundException;
import com.fake.movies.lordmathi2741.models.User;
import com.fake.movies.lordmathi2741.repositories.UserRepository;
import com.fake.movies.lordmathi2741.repositories.UserTypeRepository;
import com.fake.movies.lordmathi2741.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }
    @Override
    public Optional<User> addUser(UserDTO userDTO) {
        var user = convertToUser(userDTO);
        if(!user.getEmail().contains("@") || !user.getEmail().contains(".")){
            throw new InvalidEmailOrPassWordException();
        }
        if(user.getPassword().length() < 8){
            throw new InvalidEmailOrPassWordException();
        }
        if(userRepository.existsUserByEmailAndPassword(user.getEmail(), user.getPassword())){
            throw new UserAlreadyExistsException();
        }
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> getUserById(String id) {
       var user = userRepository.findUserById(id);
       if(user.isEmpty()){
           throw new UserNotFoundException();
       }
       return user;
    }

    @Override
    public Optional<User> updateUser(String id, UserDTO userDTO) {
        var user = userRepository.findUserById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        var userToUpdate = user.get();
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setUsername(userDTO.getUsername());
        userToUpdate.setPassword(userDTO.getPassword());
        return Optional.of(userRepository.save(userToUpdate));
    }

    @Override
    public Optional<User> updateUserRole(String id, String role) {
        var user = userRepository.findUserById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        if(userTypeRepository.existsUserTypeByType(role)){
            throw new InvalidUserRoleException();
        }
        var userToUpdate = user.get();
        userToUpdate.setRole(role);
        return Optional.of(userRepository.save(userToUpdate));
    }


    @Override
    public void deleteUser(String id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        userRepository.delete(user.get());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User convertToUser(UserDTO userDTO) {
        var user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;

    }
}
