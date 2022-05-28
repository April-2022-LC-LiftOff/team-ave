package org.launchcode.tara.controller;



import org.launchcode.tara.model.OccurrenceLog;
import org.launchcode.tara.model.User;
import org.launchcode.tara.payloads.request.OccurrenceLogRequest;

import org.launchcode.tara.repository.OccurrenceLogRepository;
import org.launchcode.tara.repository.UserRepository;
import org.launchcode.tara.service.OccurrenceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;
import java.util.Optional;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/occurrence")
public class OccurrenceLogController {

    @Autowired
    OccurrenceLogService occurrenceLogService;

    @Autowired
    OccurrenceLogRepository repo;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/log")
    public OccurrenceLog createOccurrence(@RequestBody OccurrenceLogRequest occurrenceLogRequest){
        User user = userRepository.getById(occurrenceLogRequest.getUserId());
        OccurrenceLog occurrenceLog = new OccurrenceLog(
                occurrenceLogRequest.getLocation(),
                occurrenceLogRequest.getStressors(),
                user,
                occurrenceLogRequest.getDestressors());

        occurrenceLogService.createOccurrenceLog(occurrenceLog);
        return occurrenceLog;
    }

    
    @GetMapping("/list/{id}")
    public List<?> occurrenceLogListByUserID(@PathVariable int id){
        return repo.findAllByUserId(id);
    }



}
