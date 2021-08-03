
package ru.unit.techno.arris.log.action.lib.api;

import ru.unit.techno.arris.log.action.lib.entity.Description;
import ru.unit.techno.arris.log.action.lib.model.ActionStatus;

public interface LogActionBuilder {

    void buildActionObjectAndLogAction(Long deviceId, Long commonId, String gosNumber, ActionStatus actionStatus);

    void buildActionObjectAndLogAction(Long deviceId, Long commonId, String gosNumber, ActionStatus actionStatus,
                                       boolean isErrored, Description description);
}