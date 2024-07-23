package com.fake.movies.lordmathi2741.services.impl;

import com.fake.movies.lordmathi2741.dtos.ReviewDTO;
import com.fake.movies.lordmathi2741.exceptions.ReviewNotFoundException;
import com.fake.movies.lordmathi2741.exceptions.UserNotFoundException;
import com.fake.movies.lordmathi2741.exceptions.VideoFilmNotFoundException;
import com.fake.movies.lordmathi2741.models.Review;
import com.fake.movies.lordmathi2741.repositories.ReviewRepository;
import com.fake.movies.lordmathi2741.repositories.UserRepository;
import com.fake.movies.lordmathi2741.repositories.VideoFilmRepository;
import com.fake.movies.lordmathi2741.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final VideoFilmRepository videoFilmRepository;
    private final UserRepository userRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository, VideoFilmRepository videoFilmRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.videoFilmRepository = videoFilmRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Review> addReview(ReviewDTO reviewDTO) {
        var review = convertToReview(reviewDTO);
        return Optional.of(reviewRepository.save(review));
    }

    @Override
    public Optional<Review> getReviewById(String id) {
        var review = reviewRepository.findReviewById(id);
        if(review.isEmpty()){
            throw new ReviewNotFoundException();
        }
        return Optional.of(reviewRepository.save(review.get()));
    }

    @Override
    public Optional<Review> updateReview(String id, ReviewDTO reviewDTO) {
        var review = reviewRepository.findReviewById(id);
        if(review.isEmpty()){
            throw new ReviewNotFoundException();
        }
        if(videoFilmRepository.findVideoFilmById(reviewDTO.getMovieId()).isEmpty()){
            throw new VideoFilmNotFoundException();
        }
        if(userRepository.findUserById(reviewDTO.getUserId()).isEmpty()){
            throw new UserNotFoundException();
        }
        var reviewToUpdate = review.get();
        reviewToUpdate.setRating(reviewDTO.getRating());
        reviewToUpdate.setContent(reviewDTO.getContent());
        reviewToUpdate.setMovieId(reviewDTO.getMovieId());
        reviewToUpdate.setUserId(reviewDTO.getUserId());
        return Optional.of(reviewRepository.save(reviewToUpdate));
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteReview(String id) {
        var review = reviewRepository.findReviewById(id);
        if(review.isEmpty()){
            throw new ReviewNotFoundException();
        }
        reviewRepository.delete(review.get());
    }

    private Review convertToReview(ReviewDTO reviewDTO) {
        var review = new Review();
        review.setRating(reviewDTO.getRating());
        review.setRating(reviewDTO.getRating());
        review.setMovieId(reviewDTO.getMovieId());
        review.setUserId(reviewDTO.getUserId());
        return review;
    }
}
