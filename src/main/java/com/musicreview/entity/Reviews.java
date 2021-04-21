package com.musicreview.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reviews")
public class Reviews {

    private String reviewedBy;

    private Date reviewOn;

    private String review;

    private String albumId;

    private String songId;

    public Reviews() {
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public Reviews(String reviewedBy, String review) {
        this.reviewedBy = reviewedBy;
        this.review = review;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public Date getReviewOn() {
        return reviewOn;
    }

    public void setReviewOn(Date reviewOn) {
        this.reviewOn = reviewOn;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "{" +
                "reviewedBy='" + reviewedBy + '\'' +
                ", reviewOn=" + reviewOn +
                ", review='" + review + '\'' +
                ", albumId='" + albumId + '\'' +
                ", songId='" + songId + '\'' +
                '}';
    }
}
