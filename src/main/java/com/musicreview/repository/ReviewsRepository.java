package com.musicreview.repository;

import com.musicreview.entity.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends MongoRepository<Reviews, String> {
}
