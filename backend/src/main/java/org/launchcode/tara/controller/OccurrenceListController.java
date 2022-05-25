package org.launchcode.tara.controller;

import org.launchcode.tara.model.OccurrenceList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/occurrence")
public class OccurrenceListController {


    public OccurrenceList createOccurrenceList(){
        OccurrenceList occurrenceList = new OccurrenceList();
        return occurrenceList;
    }
}
