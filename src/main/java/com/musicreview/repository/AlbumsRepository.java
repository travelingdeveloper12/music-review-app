package com.musicreview.repository;

import com.musicreview.entity.Albums;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumsRepository extends MongoRepository<Albums, String> {

}
