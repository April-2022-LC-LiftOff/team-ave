package org.launchcode.tara.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.tara.dto.InstanceRequestDto;
import org.launchcode.tara.dto.InstanceResponseDto;
import org.launchcode.tara.exception.InstanceLogNotFoundException;
import org.launchcode.tara.mapper.InstanceMapper;
import org.launchcode.tara.model.Instance;
import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.repository.InstanceLogRepository;
import org.launchcode.tara.repository.InstanceRepository;
import org.launchcode.tara.repository.UserRepository;
import org.launchcode.tara.security.services.UserDetailsImpl;
import org.launchcode.tara.security.services.UserDetailsServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class InstanceService {

    private final InstanceRepository instanceRepository;
    private final InstanceLogRepository instanceLogRepository;
    private final UserRepository userRepository;
    private final InstanceMapper instanceMapper;
    private final UserDetailsImpl userDetailsService;

    public void save(InstanceRequestDto instanceRequestDto){
        InstanceLog instanceLog = instanceLogRepository.findInstanceLogById(instanceRequestDto.getInstanceLog_id())
                .orElseThrow(()-> new InstanceLogNotFoundException("Occurrence log not found"));
        instanceRepository.save(instanceMapper.map(instanceRequestDto, instanceLog,));
    }

    @Transactional(readOnly=true)
    public InstanceResponseDto getInstance(int id){
        Instance instance = instanceRepository.getById(id);
        return InstanceMapper.mapToDTO(instance);
    }
}
