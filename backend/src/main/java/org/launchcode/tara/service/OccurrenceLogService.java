package org.launchcode.tara.service;


import org.launchcode.tara.exception.InstanceNotFoundException;
import org.launchcode.tara.model.OccurrenceLog;
import org.launchcode.tara.repository.OccurrenceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OccurrenceLogService {

    @Autowired
    private OccurrenceLogRepository repo;

    public Object createOccurrenceLog(OccurrenceLog occurrenceLog) {
        return  repo.save(occurrenceLog);
    }

    public Object updateOccurrenceLog(OccurrenceLog occurrenceLog){
        return repo.save(occurrenceLog);
    }

    public void deleteOccurrenceLog(OccurrenceLog occurrenceLog){
        repo.deleteInstanceById(occurrenceLog.getId());
    }

    public Optional<OccurrenceLog> findInstanceById(int id){
        return Optional.ofNullable(repo.findInstanceLogById(id)
                .orElseThrow(() -> new InstanceNotFoundException("Instance not found")));

    }

}
