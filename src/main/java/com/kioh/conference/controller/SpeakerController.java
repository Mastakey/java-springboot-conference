package com.kioh.conference.controller;

import java.util.List;
import java.util.Optional;

import com.kioh.conference.entity.Speaker;
import com.kioh.conference.repository.SpeakerRepository;

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
    private SpeakerRepository speakerRepository;

    @GetMapping(value = "/speakers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    @GetMapping(value = "/speakers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Speaker> get(@PathVariable Long id) {
        return speakerRepository.findById(id);
    }

    @PostMapping(value = "/speakers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speaker post(@RequestBody Speaker newSpeaker){
        return speakerRepository.save(newSpeaker);
    }

    @PutMapping(value = "/speakers/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speaker update(@RequestBody Speaker newSpeaker, @PathVariable Long id) {
        return speakerRepository.findById(id).map(speaker -> {
            speaker.setFirst_name(newSpeaker.getFirst_name());
            speaker.setLast_name(newSpeaker.getLast_name());
            speaker.setCompany(newSpeaker.getCompany());
            speaker.setSpeaker_bio(newSpeaker.getSpeaker_bio());
            speaker.setTitle(newSpeaker.getTitle());
            return speakerRepository.save(speaker);
        }).orElseGet(() -> {
            newSpeaker.setSpeaker_id(id);
            return speakerRepository.save(newSpeaker);
        });
    }

    @DeleteMapping("/speakers/{id}")
    public String delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
        return "id deleted";
    }
}