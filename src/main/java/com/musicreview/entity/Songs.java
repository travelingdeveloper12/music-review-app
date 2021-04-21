package com.musicreview.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Document(collection = "songs")
public class Songs {

    @Id
    private String id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String artistName;

    @Size(max = 60)
    private String countryArea;

    public Songs() {
    }

    public Songs(@NotBlank @Size(max = 50) String name, @NotBlank @Size(max = 50) String artistName, @Size(max = 60) String countryArea) {
        this.name = name;
        this.artistName = artistName;
        this.countryArea = countryArea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Songs{" +
                "_id=" + id +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", countryArea='" + countryArea + '\'' +
                '}';
    }
}
