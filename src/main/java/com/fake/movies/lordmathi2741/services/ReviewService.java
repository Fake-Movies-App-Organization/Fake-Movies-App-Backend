package com.fake.movies.lordmathi2741.services;

import com.fake.movies.lordmathi2741.dtos.ReviewDTO;
import com.fake.movies.lordmathi2741.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> addReview(ReviewDTO reviewDTO);
    Optional<Review> getReviewById(String id);
    Optional<Review> updateReview(String id, ReviewDTO reviewDTO);
    List<Review> getAllReviews();
    void deleteReview(String id);


}
