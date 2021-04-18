package com.musicreview.service;

import com.musicreview.dto.AlbumsDTO;
import com.musicreview.dto.SongsDTO;
import com.musicreview.entity.Albums;
import com.musicreview.entity.Songs;
import com.musicreview.repository.AlbumsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumsService {

    public static final Logger logger = LoggerFactory.getLogger(AlbumsService.class);

    @Autowired
    private AlbumsRepository albumsRepository;

    public void save(AlbumsDTO albumsDTO) {
        logger.info("Inside AlbumService layer!! - [Create Album]");
        List<Songs> songsList = new ArrayList<>();

        for (SongsDTO songsDTO : albumsDTO.getSongs()) {
            Songs song = new Songs();
            song.setName(songsDTO.getName());
            song.setArtistName(songsDTO.getArtistName());
            song.setCountryArea(songsDTO.getCountryArea());
            songsList.add(song);
        }
        Albums albums = new Albums(albumsDTO.getTitle(), albumsDTO.getLaunchYear(), albumsDTO.getGenre(),
                songsList, albumsDTO.getArtists(), albumsDTO.getReleasedBy());
        albumsRepository.save(albums);
    }

    public List<Albums> findAll(){
        logger.info("Inside AlbumService layer!! - [GET-ALL Albums]");
      return  albumsRepository.findAll();
    }

    public boolean updateById(String id, AlbumsDTO albumsDTO) {
        logger.info("Inside AlbumService layer!! - [Update Album By Id]");
        Optional<Albums> findAlbumsById = albumsRepository.findById(id);
        List<Songs> slist = new ArrayList<>();
        if (findAlbumsById.isPresent()) {
            Albums _albums = findAlbumsById.get();
            _albums.setTitle(albumsDTO.getTitle());
            _albums.setLaunchYear(albumsDTO.getLaunchYear());
            _albums.setGenre(albumsDTO.getGenre());
            for (SongsDTO songsDTO : albumsDTO.getSongs()) {
                Songs song = new Songs();
                song.setName(songsDTO.getName());
                song.setArtistName(songsDTO.getArtistName());
                song.setCountryArea(songsDTO.getCountryArea());
                slist.add(song);
            }
            _albums.setSongs(slist);
            _albums.setArtists(albumsDTO.getArtists());
            _albums.setReleasedBy(albumsDTO.getReleasedBy());
            albumsRepository.save(_albums);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAll() {
        logger.info("Inside AlbumService layer!! - [Delete All Albums]");
        try {
            albumsRepository.deleteAll();
            return true;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return false;
        }
    }

    public boolean deleteById(String id) {
        Optional<Albums> findById = albumsRepository.findById(id);
        if (findById.isPresent()) {
            albumsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
