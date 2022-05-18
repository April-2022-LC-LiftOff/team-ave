package org.launchcode.tara.controller;


import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.service.InstanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InstanceController {

    @Autowired
    private InstanceLogService service;

//    @PostMapping("/occurrence/log")
//    public InstanceLog createInstance(@RequestBody InstanceLog instanceLog){
//        service.createInstanceLog(instanceLog);
//        return instanceLog;
//    }
}
