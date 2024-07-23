package com.fake.movies.lordmathi2741.events;

import com.fake.movies.lordmathi2741.services.UserTypeService;
import com.fake.movies.lordmathi2741.services.VideoFilmTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);
    private final UserTypeService userTypeService;
    private final VideoFilmTypeService videoFilmTypeService;

    public ApplicationReadyEventHandler(UserTypeService userTypeService, VideoFilmTypeService videoFilmTypeService){
        this.userTypeService = userTypeService;
        this.videoFilmTypeService = videoFilmTypeService;
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Seed user types done {} ", applicationName);
        LOGGER.info("Seed video film types done {} ", applicationName);
        userTypeService.SeedUserTypes();
        videoFilmTypeService.SeedVideoFilmTypes();
    }

}
