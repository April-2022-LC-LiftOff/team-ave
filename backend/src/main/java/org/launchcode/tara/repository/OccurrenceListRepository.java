package org.launchcode.tara.repository;

import org.launchcode.tara.model.OccurrenceList;
import org.launchcode.tara.model.OccurrenceLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OccurrenceListRepository extends JpaRepository<OccurrenceList, Integer> {

    public OccurrenceList findListById(int id);

    Optional<OccurrenceLog> findOccurrenceLogById(int id);
}
