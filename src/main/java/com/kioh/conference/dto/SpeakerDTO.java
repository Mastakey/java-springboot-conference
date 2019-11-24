package com.kioh.conference.dto;
import com.kioh.conference.entity.Speaker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpeakerDTO {
    private Long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    public static SpeakerDTO of(Speaker speaker){
        return SpeakerDTO.builder()
            .speaker_id(speaker.getSpeaker_id())
            .first_name(speaker.getFirst_name())
            .last_name(speaker.getLast_name())
            .title(speaker.getTitle())
            .company(speaker.getCompany())
            .speaker_bio(speaker.getSpeaker_bio())
            .build();
    }
}