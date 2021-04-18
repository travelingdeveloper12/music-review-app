package com.musicreview.dto;

import java.util.List;

public class AlbumsDTO {

    private String title;

    private Integer launchYear;

    private String genre;

    private List<SongsDTO> songs;

    private List<String> artists;

    private List<String> releasedBy;

    public AlbumsDTO() {
    }

    public AlbumsDTO(String title, Integer launchYear, String genre, List<SongsDTO> songs, List<String> artists, List<String> releasedBy) {
        this.title = title;
        this.launchYear = launchYear;
        this.genre = genre;
        this.songs = songs;
        this.artists = artists;
        this.releasedBy = releasedBy;
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

    public List<SongsDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsDTO> songs) {
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
}
