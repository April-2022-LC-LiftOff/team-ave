package org.launchcode.tara.controller;


import lombok.AllArgsConstructor;
import org.launchcode.tara.dto.InstanceLogDto;
import org.launchcode.tara.service.InstanceLogService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/instanceLog")
public class InstanceLogController {

    private final InstanceLogService instanceLogService;

    @GetMapping("/{id}")
    public InstanceLogDto getInstanceLog(@PathVariable int id){
        return instanceLogService.getInstanceLog(id);
    }

    @PostMapping
    public InstanceLogDto create(@RequestBody @Valid InstanceLogDto instanceLogDto){
        return instanceLogService.save(instanceLogDto);
    }
}
