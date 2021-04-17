package com.musicreview.repository;

import com.musicreview.entity.Songs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends MongoRepository<Songs, String>{

}
