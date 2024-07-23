package com.fake.movies.lordmathi2741.repositories;

import com.fake.movies.lordmathi2741.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ReviewRepository extends MongoRepository <Review, String>{
    Optional<Review> findReviewById(String id);
}
