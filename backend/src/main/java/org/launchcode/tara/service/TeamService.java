package org.launchcode.tara.service;


import org.launchcode.tara.model.Team;
import org.launchcode.tara.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepo;

    public Team fetchTeamById(int id){
        return teamRepo.findTeamById(id);
    }


}
