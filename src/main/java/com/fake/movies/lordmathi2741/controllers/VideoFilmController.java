package com.fake.movies.lordmathi2741.controllers;
import com.fake.movies.lordmathi2741.dtos.VideoFilmDTO;
import com.fake.movies.lordmathi2741.services.VideoFilmService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value ="/api/v1/video-films", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Video Films", description = "The Video Films API")
public class VideoFilmController {
    private final VideoFilmService videoFilmService;

    public VideoFilmController(VideoFilmService videoFilmService) {
        this.videoFilmService = videoFilmService;
    }

    @GetMapping
    public ResponseEntity<?> getAllVideoFilms() {
        return ResponseEntity.ok(videoFilmService.getAllVideoFilms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVideoFilmById(@PathVariable String id) {
        return ResponseEntity.ok(videoFilmService.getVideoFilmById(id));
    }

    @PostMapping
    public ResponseEntity<?> createVideoFilm(@RequestBody VideoFilmDTO videoFilmDto) {
        return new ResponseEntity<>(videoFilmService.addVideoFilm(videoFilmDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVideoFilm(@PathVariable String id, @RequestBody VideoFilmDTO videoFilmDto) {
        return ResponseEntity.ok(videoFilmService.updateVideoFilm(id, videoFilmDto));
    }

    @PutMapping("/{id}/{type}")
    public ResponseEntity<?> updateVideoFilmType(@PathVariable String id, @PathVariable String type) {
        return ResponseEntity.ok(videoFilmService.updateVideoFilmType(id, type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVideoFilm(@PathVariable String id) {
        videoFilmService.deleteVideoFilm(id);
        return ResponseEntity.ok("Video Film deleted successfully");
    }


}
