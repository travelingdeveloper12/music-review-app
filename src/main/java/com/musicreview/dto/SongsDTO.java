package com.musicreview.dto;

public class SongsDTO {

    private String name;

    private String artistName;

    private String countryArea;

    public SongsDTO() {
    }

    public SongsDTO(String name, String artistName, String countryArea) {
        this.name = name;
        this.artistName = artistName;
        this.countryArea = countryArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(String countryArea) {
        this.countryArea = countryArea;
    }

    @Override
    public String toString() {
        return "SongsDTO{" +
                "name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", countryArea='" + countryArea + '\'' +
                '}';
    }
}
