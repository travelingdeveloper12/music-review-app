package com.musicreview.controller;

import com.musicreview.dto.AlbumsDTO;
import com.musicreview.helper.MessageResponse;
import com.musicreview.service.AlbumsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/albums")
public class AlbumController {

    public static final Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private AlbumsService albumsService;

    @GetMapping("/")
    public ResponseEntity get() {
        logger.info("Albums Controller : {GET-ALL}");
        return new ResponseEntity<>(albumsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> add(@RequestBody AlbumsDTO albumsDTO) {
        logger.info("Albums Controller : {POST}", albumsDTO.toString());
        albumsService.save(albumsDTO);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Albums Creation Successful. Created on : " + System.currentTimeMillis());
        return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody AlbumsDTO albumsDTO) {
        logger.info("Albums Controller : {PUT}", albumsDTO.toString());
        MessageResponse messageResponse = new MessageResponse();
        if (albumsService.updateById(id, albumsDTO)) {
            messageResponse.setMessage("Album Update Successful. Updated on : " + System.currentTimeMillis());
            return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable("id") String id) {
        logger.info("Albums Controller : {DELETE BY ID}", id);
        MessageResponse messageResponse = new MessageResponse();
        if (albumsService.deleteById(id)) {
            messageResponse.setMessage("Albums Delete By Id Successful. Deleted on : " + System.currentTimeMillis());
            return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.OK);
        } else {
            messageResponse.setMessage("No Albums Available");
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/albums")
    public ResponseEntity<?> deleteAllTutorials() {
        logger.info("Albums Controller : {DELETE ALL}");
        MessageResponse messageResponse = new MessageResponse();
        if (albumsService.deleteAll()) {
            messageResponse.setMessage("ALL Albums Delete Successful. Deleted on : " + System.currentTimeMillis());
            return new ResponseEntity<>(messageResponse, HttpStatus.NO_CONTENT);
        } else {
            messageResponse.setMessage("No Albums Available");
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
