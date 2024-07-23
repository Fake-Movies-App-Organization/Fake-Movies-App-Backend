package com.fake.movies.lordmathi2741.repositories;

import com.fake.movies.lordmathi2741.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findUserById(String id);
    boolean existsUserByEmailAndPassword(String email, String password);
}
