
package ru.unit.techno.arris.log.action.lib.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MetaObject {
    private String info;
    private EntryType entryType;
}