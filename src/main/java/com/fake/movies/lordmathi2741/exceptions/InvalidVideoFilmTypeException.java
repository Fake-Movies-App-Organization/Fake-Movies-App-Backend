package com.fake.movies.lordmathi2741.exceptions;

public class InvalidVideoFilmTypeException extends RuntimeException{
    public InvalidVideoFilmTypeException() {
        super("Invalid video film type. Please provide a valid video film type.");
    }
}
