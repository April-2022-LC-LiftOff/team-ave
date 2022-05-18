package org.launchcode.tara.mapper;

import org.launchcode.tara.dto.InstanceLogDto;
import org.launchcode.tara.model.Instance;
import org.launchcode.tara.model.InstanceLog;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface InstanceLogMapper {

    @Mapping(target = "numberOfInstances", expression = "java(mapInstances(instanceLog.getInstances()))")
    InstanceLogDto mapInstanceLogToDto(InstanceLog instanceLog);

    default Integer mapInstances(List<Instance> numberOfInstances){
        return numberOfInstances.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "instances", ignore = true)
    InstanceLog mapDtoToInstanceLog(InstanceLogDto instanceLog);


}
