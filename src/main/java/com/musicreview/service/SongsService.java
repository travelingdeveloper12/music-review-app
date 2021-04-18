package com.musicreview.service;

import com.musicreview.dto.SongsDTO;
import com.musicreview.entity.Songs;
import com.musicreview.repository.SongsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongsService {

    public static final Logger logger = LoggerFactory.getLogger(SongsService.class);

    @Autowired
    private SongsRepository songsRepository;

    public void save(SongsDTO songsDTO) {
        logger.info("Inside SongsService layer!! - [Create Song]");
        Songs songs = new Songs(songsDTO.getName(), songsDTO.getArtistName(), songsDTO.getCountryArea());
        songsRepository.save(songs);
    }

    public List<Songs> get() {
        logger.info("Inside SongsService layer!! - [Get Songs]");
        return songsRepository.findAll();
    }

    public boolean updateById(String id, SongsDTO songsDTO) {
        logger.info("Inside SongsService layer!! - [Update Songs By Id]");
        Optional<Songs> findSongById = songsRepository.findById(id);
        if (findSongById.isPresent()) {
            Songs _songs = findSongById.get();
            _songs.setName(songsDTO.getName());
            _songs.setArtistName(songsDTO.getArtistName());
            _songs.setCountryArea(songsDTO.getCountryArea());
            songsRepository.save(_songs);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAll() {
        logger.info("Inside SongsService layer!! - [Delete All Songs]");
        try {
            songsRepository.deleteAll();
            return true;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return false;
        }
    }

    public boolean deleteById(String id) {
        logger.info("Inside SongsService layer!! - [Delete Songs By Id]");
        Optional<Songs> findById = songsRepository.findById(id);
        if (findById.isPresent()) {
            songsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
