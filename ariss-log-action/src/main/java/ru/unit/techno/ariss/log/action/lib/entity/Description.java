package ru.unit.techno.ariss.log.action.lib.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Description {
    private String statusCode;
    private String message;
    private String erroredServiceName;
}
