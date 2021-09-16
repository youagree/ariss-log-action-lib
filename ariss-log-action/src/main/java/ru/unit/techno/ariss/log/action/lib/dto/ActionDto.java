
package ru.unit.techno.ariss.log.action.lib.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ru.unit.techno.ariss.log.action.lib.entity.Description;

import java.time.LocalDateTime;

@Data
public class ActionDto {
    private Long id;
    private Long rfidLabelValue;
    private Long deviceId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime eventTime;
    private String eventType;
    private String info;
    private String stateOfAction;
    private String gosNumber;
    private boolean isErrored;
    private Description description;
}