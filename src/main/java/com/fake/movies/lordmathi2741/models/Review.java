package com.fake.movies.lordmathi2741.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "reviews")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private String id;

    @Setter
    private String content;

    @Setter
    private int rating;

    @CreatedDate
    private Date createdAt;


    private String movieId;
    private String userId;



}
