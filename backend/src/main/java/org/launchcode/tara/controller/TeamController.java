package org.launchcode.tara.controller;
import org.launchcode.tara.model.Team;
import org.launchcode.tara.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/friends")
public class TeamController {

    @Autowired
    private TeamService service;

    @PostMapping
    public Team createUserTeam(){
        Team team = new Team();
        return team;
    }



}
