
package ru.unit.techno.arris.log.action.lib.model;

import lombok.Getter;

public enum EntryType {
    IN("ВЪЕЗД"),
    OUT("ВЫЕЗД"),
    UNKNOWN("НЕИЗВЕСТНО");

    @Getter
    private final String value;

    EntryType(String value) {
        this.value = value;
    }
}