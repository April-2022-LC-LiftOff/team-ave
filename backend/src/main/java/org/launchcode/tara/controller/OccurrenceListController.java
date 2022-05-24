package org.launchcode.tara.controller;


import org.launchcode.tara.model.OccurrenceList;
import org.launchcode.tara.model.OccurrenceLog;
import org.launchcode.tara.repository.OccurrenceListRepository;
import org.launchcode.tara.repository.UserRepository;
import org.launchcode.tara.service.OccurrenceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/occurrence")
public class OccurrenceListController {

    @Autowired
    OccurrenceLogService occurrenceLogService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OccurrenceListRepository occurrenceListRepository;

    public OccurrenceList createOccurrenceList(){
        OccurrenceList occurrenceList = new OccurrenceList();
        return occurrenceList;
    }
}
