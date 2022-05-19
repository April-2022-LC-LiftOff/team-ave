package org.launchcode.tara.mapper;


import org.launchcode.tara.dto.InstanceRequestDto;
import org.launchcode.tara.dto.InstanceResponseDto;
import org.launchcode.tara.model.Instance;
import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class InstanceMapper {


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now()")
    @Mapping(target = "location", source="instanceDto.location")
    @Mapping(target = "stressors", source="instanceDto.stressors")
    @Mapping(target = "instanceLog", source="instanceLog")
    @Mapping(target = "userId", source="user.user_id")
    @Mapping(target = "deescalation", source="instanceDto.deescalation")
    public abstract Instance map(InstanceRequestDto instanceDto, InstanceLog instanceLog, User user);

    @Mapping(target = "id", source = "instance_id")
    @Mapping(target = "InstanceLogName", source = "instanceLog.name")
    @Mapping(target = "userName", source = "user.username")
    public static InstanceResponseDto mapToDTO(Instance instance) {
        return null;
    }

}
