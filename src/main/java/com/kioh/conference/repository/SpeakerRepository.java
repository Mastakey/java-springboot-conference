package com.kioh.conference.repository;
import java.util.List;
import com.kioh.conference.entity.Speaker;
import org.springframework.data.repository.CrudRepository;

public interface SpeakerRepository extends CrudRepository<Speaker, Long>{
    @Override
    List<Speaker> findAll();
}