package org.launchcode.tara.controller;


import org.launchcode.tara.exception.InstanceNotFoundException;
import org.launchcode.tara.model.OccurrenceLog;
import org.launchcode.tara.model.User;
import org.launchcode.tara.payloads.request.OccurrenceLogRequest;
import org.launchcode.tara.payloads.response.OccurrenceLogResponse;
import org.launchcode.tara.repository.OccurrenceLogRepository;
import org.launchcode.tara.repository.UserRepository;
import org.launchcode.tara.service.OccurrenceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.status;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/occurrence")
public class OccurrenceLogController {

    @Autowired
    OccurrenceLogService occurrenceLogService;

    @Autowired
    OccurrenceLogRepository occurrenceLogRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/log")
    public OccurrenceLog createOccurrence(@RequestBody OccurrenceLogRequest occurrenceLogRequest){
        User user = userRepository.getById(occurrenceLogRequest.getUserId());
        OccurrenceLog occurrenceLog = new OccurrenceLog(occurrenceLogRequest.getLocation(),
                occurrenceLogRequest.getStressors(),
                user,
                occurrenceLogRequest.getDate(),
                occurrenceLogRequest.getDestressors());

        occurrenceLogService.createOccurrenceLog(occurrenceLog);
        return occurrenceLog;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOccurrenceById(@PathVariable int id){
        OccurrenceLog occurrenceLog = occurrenceLogRepository.findInstanceLogById(id)
                .orElseThrow(()-> new InstanceNotFoundException("Specific instance not found"));
        return ResponseEntity.ok(new OccurrenceLogResponse(occurrenceLog.getDate(),
                occurrenceLog.getLocation(),
                occurrenceLog.getStressors(),
                occurrenceLog.getDestressors(),
                occurrenceLog.getUser()
                ));
    }


}
