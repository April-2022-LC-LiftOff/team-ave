package org.launchcode.tara.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.tara.mapper.InstanceMapper;
import org.launchcode.tara.repository.InstanceLogRepository;
import org.launchcode.tara.repository.InstanceRepository;
import org.launchcode.tara.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class InstanceService {

    private final InstanceRepository instanceRepository;
    private final InstanceLogRepository instanceLogRepository;
    private final UserRepository userRepository;
    private final InstanceMapper instanceMapper;

//    @Transactional
//    public InstanceDto getInstance(int id){
//        Instance instance = instanceRepository.getById(id)
//                .orElseThrow(()-> new InstanceNotFoundException(id.toString()));
//                return InstanceMapper.map(id);
//    }
}
