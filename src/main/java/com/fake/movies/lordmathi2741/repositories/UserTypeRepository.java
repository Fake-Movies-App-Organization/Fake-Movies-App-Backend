package com.fake.movies.lordmathi2741.repositories;

import com.fake.movies.lordmathi2741.models.UserType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends MongoRepository<UserType,String> {
    boolean existsUserTypeByType(String type);
}
