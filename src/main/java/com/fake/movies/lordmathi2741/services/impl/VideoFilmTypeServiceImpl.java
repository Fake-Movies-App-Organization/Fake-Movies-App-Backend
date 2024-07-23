package com.fake.movies.lordmathi2741.services.impl;

import com.fake.movies.lordmathi2741.models.VideoFilmType;
import com.fake.movies.lordmathi2741.models.VideoFilmTypes;
import com.fake.movies.lordmathi2741.repositories.VideoFilmTypeRepository;
import com.fake.movies.lordmathi2741.services.VideoFilmTypeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class VideoFilmTypeServiceImpl implements VideoFilmTypeService {

    private final VideoFilmTypeRepository videoFilmTypeRepository;
    public VideoFilmTypeServiceImpl(VideoFilmTypeRepository videoFilmTypeRepository) {
        this.videoFilmTypeRepository = videoFilmTypeRepository;
    }
    @Override
    public void SeedVideoFilmTypes() {
        Arrays.stream(VideoFilmTypes.values()).forEach(videoFilmType -> {
            if (!videoFilmTypeRepository.existsVideoFilmTypeByType(videoFilmType.toString())){
                videoFilmTypeRepository.save(new VideoFilmType(videoFilmType.toString()));
            }
        });
    }
}
