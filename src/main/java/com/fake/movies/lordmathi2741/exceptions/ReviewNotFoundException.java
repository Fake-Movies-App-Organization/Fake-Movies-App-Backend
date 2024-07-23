package com.fake.movies.lordmathi2741.exceptions;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException() {
        super("Review not found");
    }
}
