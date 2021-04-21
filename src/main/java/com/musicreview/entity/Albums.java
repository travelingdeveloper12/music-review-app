package com.musicreview.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Document(collection = "albums")
public class Albums {

    @Id
    private String id;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    private Integer launchYear;

    @NotBlank
    private String genre;

    @NotBlank
    private List<Songs> songs;

    @NotBlank
    private List<String> artists;

    @NotBlank
    private List<String> releasedBy;

    private List<Reviews> reviews;

    public Albums() {
    }

    public Albums(@NotBlank @Size(max = 50) String title, @NotBlank Integer launchYear, @NotBlank String genre, @NotBlank List<Songs> songs, @NotBlank List<String> artists, @NotBlank List<String> releasedBy) {
        this.title = title;
        this.launchYear = launchYear;
        this.genre = genre;
        this.songs = songs;
        this.artists = artists;
        this.releasedBy = releasedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(Integer launchYear) {
        this.launchYear = launchYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public List<String> getReleasedBy() {
        return releasedBy;
    }

    public void setReleasedBy(List<String> releasedBy) {
        this.releasedBy = releasedBy;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", launchYear=" + launchYear +
                ", genre='" + genre + '\'' +
                ", songs=" + songs +
                ", artists=" + artists +
                ", releasedBy=" + releasedBy +
                ", reviews=" + reviews +
                '}';
    }
}

