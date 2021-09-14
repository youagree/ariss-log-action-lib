
package ru.unit.techno.ariss.log.action.lib.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MetaObject {
    private String info;
    private EntryType entryType;
}