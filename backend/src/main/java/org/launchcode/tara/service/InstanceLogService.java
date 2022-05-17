package org.launchcode.tara.service;


import org.launchcode.tara.dto.InstanceLogDto;
import org.launchcode.tara.exception.InstanceNotFoundException;
import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.repository.InstanceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstanceLogService {

    @Autowired
    private InstanceLogRepository repo;

    public void createLog(InstanceLogDto instanceLogDto){
        InstanceLog instanceLog = new InstanceLog();
    }




}
