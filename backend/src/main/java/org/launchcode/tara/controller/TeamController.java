package org.launchcode.tara.controller;


import org.launchcode.tara.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TeamController {

    @Autowired
    private TeamService Service;
}
