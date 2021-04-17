package com.musicreview.service;

import com.musicreview.dto.SongsDTO;
import com.musicreview.entity.Songs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.musicreview.repository.SongsRepository;

@Service
public class SongsService {

    public static final Logger logger = LoggerFactory.getLogger(SongsService.class);

    @Autowired
    private SongsRepository songsRepository;

    public void save(SongsDTO songsDTO) {
        logger.info("Inside SongsService layer!!");
        Songs songs = new Songs(songsDTO.getName(), songsDTO.getArtistName(), songsDTO.getCountryArea());
        songsRepository.save(songs);
    }

}
