package org.launchcode.tara.repository;
import org.launchcode.tara.model.OccurrenceList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccurrenceListRepository extends JpaRepository<OccurrenceList, Integer> {

    OccurrenceList findListById(int id);


}
