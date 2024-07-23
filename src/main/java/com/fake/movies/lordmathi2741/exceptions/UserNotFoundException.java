package com.fake.movies.lordmathi2741.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User not found, please check the user id and try again.");
    }
}
