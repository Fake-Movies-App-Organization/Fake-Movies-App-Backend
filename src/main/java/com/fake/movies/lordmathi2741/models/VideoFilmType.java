package com.fake.movies.lordmathi2741.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Document(collection = "video_film_types")
public class VideoFilmType {

    @Id
    private String id;

    @Setter
    private String type;

    public VideoFilmType(String type) {
        this.type = type;
    }
}
