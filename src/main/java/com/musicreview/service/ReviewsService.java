package com.musicreview.service;

import com.musicreview.dto.AlbumsDTO;
import com.musicreview.entity.Reviews;
import com.musicreview.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public void addReview(AlbumsDTO albumsDTO) {
        Reviews reviews = new Reviews();
        reviews.setReviewedBy(albumsDTO.getReview().getReviewedBy());
        reviews.setReview(albumsDTO.getReview().getReview());
        reviews.setReviewOn(new Date());
        reviewsRepository.save(reviews);
    }
}
