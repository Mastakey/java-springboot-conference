package com.kioh.conference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kioh.conference.repository.SpeakerRepository;
import com.kioh.conference.dto.SpeakerDTO;
import com.kioh.conference.entity.Speaker;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    public List<SpeakerDTO> getSpeakers() {
        List<Speaker> speakers = speakerRepository.findAll();
        return speakers.stream().map(SpeakerDTO::of).collect(Collectors.toList());
    }

    public SpeakerDTO findOne(Long id) {
        Optional<Speaker> speaker = speakerRepository.findById(id);
        return SpeakerDTO.of(speaker.get());
    }

    public SpeakerDTO create(SpeakerDTO speakerDTO){
        Speaker speaker = Speaker.builder()
            .speaker_id(speakerDTO.getSpeaker_id())
            .first_name(speakerDTO.getFirst_name())
            .last_name(speakerDTO.getLast_name())
            .title(speakerDTO.getTitle())
            .company(speakerDTO.getCompany())
            .speaker_bio(speakerDTO.getSpeaker_bio())
            .build();
        Speaker createdSpeaker = speakerRepository.save(speaker);
        return SpeakerDTO.of(createdSpeaker);
    }

    
}