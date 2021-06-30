package com.example.challegerdisney.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;
    private String title;
    private String image_url;
    private Integer year;
    private  Integer score;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Character> characters;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Genre> genres;


    public Movie() {
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", year=" + year +
                ", score=" + score +
                '}';
    }
}
