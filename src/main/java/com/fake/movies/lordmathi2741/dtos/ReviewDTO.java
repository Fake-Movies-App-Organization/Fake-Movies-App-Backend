package com.fake.movies.lordmathi2741.dtos;

import lombok.Data;

@Data
public class ReviewDTO {
    private String content;
    private int rating;
    private String movieId;
    private String userId;
}
