package com.musicreview.controller;

import com.musicreview.dto.SongsDTO;
import com.musicreview.helper.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.musicreview.service.SongsService;

@RestController
@RequestMapping("/songs")
public class SongsController {

    public static final Logger logger = LoggerFactory.getLogger(SongsController.class);

    @Autowired
    private SongsService songsService;

    @GetMapping("/")
    public String checkController(){
        return "The controller is reachable";
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SongsDTO songsDTO) {
        logger.info("Songs Controller : {}", songsDTO.toString());
        songsService.save(songsDTO);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Song Creation Successful. Created on : " + System.currentTimeMillis());
        return new ResponseEntity<>(messageResponse.getMessage(), HttpStatus.CREATED);
    }
}
