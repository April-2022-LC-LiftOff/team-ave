package org.launchcode.tara.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.launchcode.tara.model.InstanceLog;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstanceRequestDto {


    private String location;
    private String stressors;
    private String deescalation;
    private int userId;
    private int instanceLog_id;



}
