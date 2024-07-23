package com.fake.movies.lordmathi2741.repositories;

import com.fake.movies.lordmathi2741.models.VideoFilmType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFilmTypeRepository extends MongoRepository<VideoFilmType,String> {
    boolean existsVideoFilmTypeByType(String type);
}
