package org.launchcode.tara.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.tara.dto.InstanceLogDto;
import org.launchcode.tara.exception.InstanceLogNotFoundException;
import org.launchcode.tara.exception.InstanceNotFoundException;
import org.launchcode.tara.mapper.InstanceLogMapper;
import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.repository.InstanceLogRepository;
import org.launchcode.tara.repository.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class InstanceLogService {

    private final InstanceLogRepository instanceLogRepository;

    private final InstanceLogMapper instanceLogMapper;

    @Transactional
    public InstanceLogDto save(InstanceLogDto instanceLogDto){
        InstanceLog save = instanceLogRepository.save(instanceLogMapper.mapDtoToInstanceLog(instanceLogDto));
        instanceLogDto.setId(save.getId());
        return instanceLogDto;
    }



    public InstanceLogDto getInstanceLog(int id){
        InstanceLog instanceLog = instanceLogRepository.findInstanceLogById(id)
                .orElseThrow(()-> new InstanceLogNotFoundException("Your Occurrence log was not found"));
        return instanceLogMapper.mapInstanceLogToDto(instanceLog);
    }
}
