package org.launchcode.tara.service;

import org.launchcode.tara.model.OccurrenceList;
import org.launchcode.tara.repository.OccurrenceListRepository;
import org.launchcode.tara.repository.OccurrenceLogRepository;
import org.launchcode.tara.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OccurrenceListService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private OccurrenceLogRepository occurrenceLogRepository;

    @Autowired
    private OccurrenceListRepository occurrenceListRepository;

    @Transactional
    public Object createOccurrenceList(OccurrenceList occurrenceList) {
        return occurrenceListRepository.save(occurrenceList);
    }

    public OccurrenceList getOccurrenceList( int id ){
        return occurrenceListRepository.findListById(id);
    }

}
