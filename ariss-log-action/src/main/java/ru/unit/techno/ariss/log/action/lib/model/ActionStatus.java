
package ru.unit.techno.ariss.log.action.lib.model;

import lombok.Getter;

public enum ActionStatus {
    UNKNOWN("неизвестный"),
    ACTIVE("активный"),
    NO_ACTIVE("остановлен/просрочен");

    @Getter
    private final String value;

    ActionStatus(String value) {
        this.value = value;
    }
}