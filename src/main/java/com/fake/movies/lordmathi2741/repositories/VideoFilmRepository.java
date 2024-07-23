package com.fake.movies.lordmathi2741.repositories;

import com.fake.movies.lordmathi2741.models.VideoFilm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VideoFilmRepository extends MongoRepository<VideoFilm, String> {
    Optional<VideoFilm> findVideoFilmById(String id);
}

