package org.launchcode.tara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstanceLogDto {


    private int id;
    private String name;
    private int userId;
    private int numberOfInstances;

}
