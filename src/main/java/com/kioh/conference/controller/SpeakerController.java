package com.kioh.conference.controller;

import java.util.List;

import com.kioh.conference.dto.SpeakerDTO;
import com.kioh.conference.service.SpeakerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return speakerService.findOne(id);
    }

    @PostMapping(value = "/speakers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpeakerDTO add(@RequestBody SpeakerDTO newSpeaker){
        return speakerService.create(newSpeaker);
    }

    @PutMapping(value = "/speakers/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpeakerDTO update(@RequestBody SpeakerDTO newSpeaker, @PathVariable Long id) {
        return speakerService.update(newSpeaker, id);
    }

    @DeleteMapping("/speakers/{id}")
    public String delete(@PathVariable Long id) {
        return speakerService.delete(id);
    }
}