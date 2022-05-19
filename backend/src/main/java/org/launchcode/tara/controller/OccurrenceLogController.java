package org.launchcode.tara.controller;


import org.launchcode.tara.model.OccurrenceLog;
import org.launchcode.tara.model.User;
import org.launchcode.tara.payloads.request.OccurrenceLogRequest;
import org.launchcode.tara.repository.OccurrenceLogRepository;
import org.launchcode.tara.repository.UserRepository;
import org.launchcode.tara.service.OccurrenceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http:localhost:4200")
@RestController
@RequestMapping("/api/auth/occurrence")
public class OccurrenceLogController {

    @Autowired
    OccurrenceLogService occurrenceLogService;

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
}
