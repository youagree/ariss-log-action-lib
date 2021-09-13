
package ru.unit.techno.ariss.log.action.lib.api;

import ru.unit.techno.ariss.log.action.lib.model.ActionObject;

public interface LogAction {
    void logSuccessAction(ActionObject actionObject);

    void logExceptionObject(ActionObject actionObject);
}