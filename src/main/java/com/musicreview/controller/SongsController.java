package com.musicreview.controller;

import com.musicreview.dto.SongsDTO;
import com.musicreview.helper.MessageResponse;
import com.musicreview.service.SongsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongsController {

    public static final Logger logger = LoggerFactory.getLogger(SongsController.class);

    @Autowired
    private SongsService songsService;

    @GetMapping("/")
    public ResponseEntity<?> get() {
        logger.info("Songs Controller : {GET ALL}");
        return new ResponseEntity<>(songsService.get(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SongsDTO songsDTO) {
        logger.info("Songs Controller : {POST}", songsDTO.toString());
        songsService.save(songsDTO);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Song Creation Successful. Created on : " + System.currentTimeMillis());
        return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody SongsDTO songsDTO) {
        logger.info("Songs Controller : {PUT}", songsDTO.toString());
        MessageResponse messageResponse = new MessageResponse();
        if (songsService.updateById(id, songsDTO)) {
            messageResponse.setMessage("Song Update Successful. Updated on : " + System.currentTimeMillis());
            return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/update/{id}")
    public ResponseEntity<?> deleteTutorial(@PathVariable("id") String id) {
        logger.info("Songs Controller : {DELETE BY ID}", id);
        MessageResponse messageResponse = new MessageResponse();
        if (songsService.deleteById(id)) {
            messageResponse.setMessage("Song Delete By Id Successful. Deleted on : " + System.currentTimeMillis());
            return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.OK);
        } else {
            messageResponse.setMessage("No Songs Available");
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/songs")
    public ResponseEntity<?> deleteAllTutorials() {
        logger.info("Songs Controller : {DELETE ALL}");
        MessageResponse messageResponse = new MessageResponse();
        if (songsService.deleteAll()) {
            messageResponse.setMessage("ALL Songs Delete Successful. Deleted on : " + System.currentTimeMillis());
            return new ResponseEntity<>(messageResponse, HttpStatus.NO_CONTENT);
        } else {
            messageResponse.setMessage("No Songs Available");
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
