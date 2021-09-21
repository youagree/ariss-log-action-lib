package ru.unit.techno.ariss.log.action.lib.model;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.unit.techno.ariss.log.action.lib.entity.Description;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ActionObject {
    private Long commonId;
    private Long deviceId;
    private LocalDateTime eventTime;
    private ActionStatus actionStatus;
    private String gosNumber;
    private Boolean isErrored = false;
    private Description description;
}