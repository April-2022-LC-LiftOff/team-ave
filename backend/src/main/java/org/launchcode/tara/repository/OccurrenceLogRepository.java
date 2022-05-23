package org.launchcode.tara.repository;

import org.launchcode.tara.model.OccurrenceLog;
import org.launchcode.tara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OccurrenceLogRepository extends JpaRepository<OccurrenceLog, Integer> {

    public OccurrenceLog findInstanceByUser(User user);

    void deleteInstanceById(int id);

    Optional<OccurrenceLog> findInstanceLogById(int id);

    List<OccurrenceLog> findAllByUserId(int id);
}
