
package ru.unit.techno.arris.log.action.lib.model;

import lombok.Getter;

public enum ActionStatus {
    UNKNOWN("неизвестный"),
    ACTIVE("активный"),
    STOP("остановлен/просрочен");

    @Getter
    private final String value;

    ActionStatus(String value) {
        this.value = value;
    }
}