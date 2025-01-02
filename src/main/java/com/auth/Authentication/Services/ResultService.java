package com.auth.Authentication.Services;


import com.auth.Authentication.Repository.AthleteRepository;
import com.auth.Authentication.Repository.EventRepository;
import com.auth.Authentication.Repository.ResultRepository;
import com.auth.Authentication.dto.ResultDTO;
import com.auth.Authentication.entity.Registration;
import com.auth.Authentication.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    public Optional<Result> findByAthleteIDAndEventId(Long athleteId, Long eventId) {
        return resultRepository.findByAthleteIdAndEventId(athleteId, eventId);
    }

    public List<Result> findByAthleteId(Long athleteId) {
        return resultRepository.findByAthleteId(athleteId);
    }

    public List<Result> findByEventId(Long eventId) {
        return resultRepository.findByEventId(eventId);
    }

    public void createResult(ResultDTO resultDTOObject) {
        Result result = new Result();
        result.setAthleteId(resultDTOObject.getAthleteId());
        result.setEventId(resultDTOObject.getEventId());
        result.setPublishDate(resultDTOObject.getPublishDate());
        result.setScore(resultDTOObject.getScore());
        result.setRemarks(resultDTOObject.getRemarks());

        resultRepository.save(result);
    }

    public List<Result> getAllResult() {
        //get All registrations
            return resultRepository.findAll();
        }
}
