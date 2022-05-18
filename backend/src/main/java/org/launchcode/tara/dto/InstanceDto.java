package org.launchcode.tara.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.launchcode.tara.model.InstanceLog;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstanceDto {


    private String location;
    private String stressors;
    private String deescalation;
    private int userId;
    private InstanceLog instanceLog;



}
