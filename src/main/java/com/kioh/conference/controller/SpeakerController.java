package com.kioh.conference.controller;

import java.util.List;

import com.kioh.conference.dto.SpeakerDTO;
import com.kioh.conference.service.SpeakerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @GetMapping(value = "/speakers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SpeakerDTO> findAll() {
        return speakerService.getSpeakers();
    }

    @GetMapping(value = "/speakers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SpeakerDTO get(@PathVariable Long id) {
        try {
            return speakerService.findOne(id);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        
    }

    @PostMapping(value = "/speakers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpeakerDTO add(@RequestBody SpeakerDTO newSpeaker){
        try {
            return speakerService.create(newSpeaker);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
        
    }

    @PutMapping(value = "/speakers/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpeakerDTO update(@RequestBody SpeakerDTO newSpeaker, @PathVariable Long id) {
        try {
            return speakerService.update(newSpeaker, id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping("/speakers/{id}")
    public String delete(@PathVariable Long id) {
        try {
            return speakerService.delete(id);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        
    }
}