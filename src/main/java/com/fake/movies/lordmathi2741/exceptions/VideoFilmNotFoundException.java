package com.fake.movies.lordmathi2741.exceptions;

public class VideoFilmNotFoundException extends RuntimeException{
    public VideoFilmNotFoundException() {
        super("Video Film not found, please check the id and try again.");
    }
}
