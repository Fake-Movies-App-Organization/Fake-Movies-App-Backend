package com.fake.movies.lordmathi2741.services.impl;

import com.fake.movies.lordmathi2741.models.UserType;
import com.fake.movies.lordmathi2741.models.UserTypes;
import com.fake.movies.lordmathi2741.repositories.UserTypeRepository;
import com.fake.movies.lordmathi2741.services.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;
    public UserTypeServiceImpl(UserTypeRepository userTypeRepository){
        this.userTypeRepository = userTypeRepository;
    }
    @Override
    public void SeedUserTypes() {
        Arrays.stream(UserTypes.values()).forEach(userType -> {
            if(userTypeRepository.existsUserTypeByType(userType.toString())){
                userTypeRepository.save(new UserType(userType.toString()));
            }
        });
    }
}
