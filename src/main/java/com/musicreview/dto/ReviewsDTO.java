package com.musicreview.dto;

public class ReviewsDTO {
    private String reviewedBy;

    private String review;

    public ReviewsDTO() {
    }

    public ReviewsDTO(String reviewedBy, String review) {
        this.reviewedBy = reviewedBy;
        this.review = review;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
