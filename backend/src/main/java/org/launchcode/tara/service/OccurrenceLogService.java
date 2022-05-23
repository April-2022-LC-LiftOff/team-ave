package org.launchcode.tara.service;


import org.launchcode.tara.exception.InstanceNotFoundException;
import org.launchcode.tara.model.OccurrenceLog;
import org.launchcode.tara.model.User;
import org.launchcode.tara.payloads.response.OccurrenceLogResponse;
import org.launchcode.tara.repository.OccurrenceLogRepository;
import org.launchcode.tara.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class OccurrenceLogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OccurrenceLogRepository repo;


    @Transactional
    public Object createOccurrenceLog(OccurrenceLog occurrenceLog) {
        return repo.save(occurrenceLog);
    }

    @Transactional
    public Object updateOccurrenceLog(OccurrenceLog occurrenceLog) {
        return repo.save(occurrenceLog);
    }

    @Transactional
    public void deleteOccurrenceLog(OccurrenceLog occurrenceLog) {
        repo.deleteInstanceById(occurrenceLog.getId());
    }

    @Transactional
    public Optional<OccurrenceLog> findInstanceById(int id) {
        return Optional.ofNullable(repo.findInstanceLogById(id)
                .orElseThrow(() -> new InstanceNotFoundException("Instance not found")));
    }
}
