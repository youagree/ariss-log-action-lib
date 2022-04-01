
package ru.unit.techno.ariss.log.action.lib.model;

import lombok.Getter;

public enum ActionStatus {
    UNKNOWN("UNKNOWN"),
    ACTIVE("ACTIVE"),
    NO_ACTIVE("NO_ACTIVE");

    @Getter
    private final String value;

    ActionStatus(String value) {
        this.value = value;
    }
}