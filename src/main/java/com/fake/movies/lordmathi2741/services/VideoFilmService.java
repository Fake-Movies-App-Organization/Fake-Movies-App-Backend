package com.fake.movies.lordmathi2741.services;

import com.fake.movies.lordmathi2741.dtos.VideoFilmDTO;
import com.fake.movies.lordmathi2741.models.VideoFilm;

import java.util.List;
import java.util.Optional;

public interface VideoFilmService {
    Optional<VideoFilm> addVideoFilm(VideoFilmDTO videoFilmDTO);
    Optional<VideoFilm> getVideoFilmById(String id);
    Optional<VideoFilm> updateVideoFilm(String id, VideoFilmDTO videoFilmDTO);
    Optional<VideoFilm> updateVideoFilmType(String id, String type);
    void deleteVideoFilm(String id);
    List<VideoFilm> getAllVideoFilms();
}
