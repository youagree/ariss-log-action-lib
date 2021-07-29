package ru.unit.techno.arris.log.action.lib.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActionObject {
    private Long rfidLabelValue;
    private Long deviceId;
    private LocalDateTime eventTime;
    private ActionStatus actionStatus;
    private String gosNumber;
}