
package ru.unit.techno.ariss.log.action.lib.api;

import ru.unit.techno.ariss.log.action.lib.model.ActionStatus;
import ru.unit.techno.ariss.log.action.lib.entity.Description;

public interface LogActionBuilder {

    void buildActionObjectAndLogAction(Long deviceId, Long commonId, String gosNumber, ActionStatus actionStatus);

    void buildActionObjectAndLogAction(Long deviceId, Long commonId, String gosNumber, ActionStatus actionStatus,
                                       boolean isErrored, Description description);
}