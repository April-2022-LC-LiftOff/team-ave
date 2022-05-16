//package org.launchcode.tara.controller;
//
//
//import org.launchcode.tara.model.Team;
//import org.launchcode.tara.service.TeamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins="http://localhost:4200")
//public class TeamController {
//
//    @Autowired
//    private TeamService service;
//
//    @GetMapping("/team/{id}")
//    public Team getTeamById(@PathVariable("id") int id) throws Exception{
//        return service.fetchTeamById(id);
//    }
//
//}
