package org.launchcode.tara.service;


import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.repository.InstanceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstanceLogService {

    @Autowired
    private InstanceLogRepository repo;

    public Object createInstanceLog(InstanceLog instanceLog) {
        return  repo.save(instanceLog);
    }

    public Object updateInstanceLog(InstanceLog instanceLog){
        return repo.save(instanceLog);
    }

    public void deleteInstanceLog(InstanceLog instanceLog){
        repo.deleteInstanceById(instanceLog.getId());
    }


}
