package com.fake.movies.lordmathi2741.services.impl;

import com.fake.movies.lordmathi2741.dtos.VideoFilmDTO;
import com.fake.movies.lordmathi2741.exceptions.InvalidVideoFilmTypeException;
import com.fake.movies.lordmathi2741.exceptions.VideoFilmNotFoundException;
import com.fake.movies.lordmathi2741.models.VideoFilm;
import com.fake.movies.lordmathi2741.repositories.VideoFilmRepository;
import com.fake.movies.lordmathi2741.repositories.VideoFilmTypeRepository;
import com.fake.movies.lordmathi2741.services.VideoFilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VideoFilmServiceImpl implements VideoFilmService {

    private final VideoFilmRepository videoFilmRepository;
    private final VideoFilmTypeRepository videoFilmTypeRepository;

    public VideoFilmServiceImpl(VideoFilmRepository videoFilmRepository, VideoFilmTypeRepository videoFilmTypeRepository) {
        this.videoFilmRepository = videoFilmRepository;
        this.videoFilmTypeRepository = videoFilmTypeRepository;
    }
    @Override
    public Optional<VideoFilm> addVideoFilm(VideoFilmDTO videoFilmDTO) {
        var videoFilm = convertToVideoFilm(videoFilmDTO);
        return Optional.of(videoFilmRepository.save(videoFilm));
    }

    @Override
    public Optional<VideoFilm> getVideoFilmById(String id) {
        var videoFilm = videoFilmRepository.findVideoFilmById(id);
        if(videoFilm.isEmpty()){
            throw new VideoFilmNotFoundException();
        }
        return videoFilm;
    }

    @Override
    public Optional<VideoFilm> updateVideoFilm(String id, VideoFilmDTO videoFilmDTO) {
        var videoFilm = videoFilmRepository.findVideoFilmById(id);
        if(videoFilm.isEmpty()){
            throw new VideoFilmNotFoundException();
        }
        videoFilm.get().setTitle(videoFilmDTO.getTitle());
        videoFilm.get().setDescription(videoFilmDTO.getDescription());
        videoFilm.get().setDuration(videoFilmDTO.getDuration());
        videoFilm.get().setMovieBanner(videoFilmDTO.getMovieBanner());
        videoFilm.get().setMovieUrl(videoFilmDTO.getMovieUrl());
        videoFilm.get().setYear(videoFilmDTO.getYear());
        videoFilmRepository.save(videoFilm.get());
        return videoFilm;
    }

    @Override
    public Optional<VideoFilm> updateVideoFilmType(String id, String type) {
        var videoFilm = videoFilmRepository.findVideoFilmById(id);
        if(videoFilm.isEmpty()){
            throw new VideoFilmNotFoundException();
        }
        if(!videoFilmTypeRepository.existsVideoFilmTypeByType(type)){
            throw new InvalidVideoFilmTypeException();
        }
        videoFilm.get().setType(type);
        videoFilmRepository.save(videoFilm.get());
        return videoFilm;
    }

    @Override
    public void deleteVideoFilm(String id) {
        var videoFilm = videoFilmRepository.findVideoFilmById(id);
        if(videoFilm.isEmpty()){
            throw new VideoFilmNotFoundException();
        }
        videoFilmRepository.delete(videoFilm.get());
    }

    @Override
    public List<VideoFilm> getAllVideoFilms() {
        return videoFilmRepository.findAll();
    }

    private VideoFilm convertToVideoFilm(VideoFilmDTO videoFilmDTO) {
        var videoFilm = new VideoFilm();
        videoFilm.setTitle(videoFilmDTO.getTitle());
        videoFilm.setDescription(videoFilmDTO.getDescription());
        videoFilm.setDuration(videoFilmDTO.getDuration());
        videoFilm.setMovieBanner(videoFilmDTO.getMovieBanner());
        videoFilm.setMovieUrl(videoFilmDTO.getMovieUrl());
        videoFilm.setYear(videoFilm.getYear());
        return videoFilm;
    }
}
