package com.fake.movies.lordmathi2741.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(value = "video_films")
@Data
public class VideoFilm {
    @Id
    private String id;
    @Setter
    private String title;
    @Setter
    private String description;
    @Setter
    private String duration;
    @Setter
    private String type;
    @Setter
    private String movieUrl;
    @Setter
    private String movieBanner;
    @Setter
    private int year;

    public VideoFilm(){
        this.type = VideoFilmTypes.Movie.toString();
    }


    public VideoFilm(String title, String description, String duration, String movieUrl, String movieBanner, int year){
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.movieUrl = movieUrl;
        this.movieBanner = movieBanner;
        this.year = year;
        this.type = VideoFilmTypes.Movie.toString();
    }


}
