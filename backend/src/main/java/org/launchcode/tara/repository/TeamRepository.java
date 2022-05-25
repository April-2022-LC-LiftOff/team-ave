package org.launchcode.tara.repository;
import org.launchcode.tara.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Integer> {
    Team findTeamById(int id);

}
