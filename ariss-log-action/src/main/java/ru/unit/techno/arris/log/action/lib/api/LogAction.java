
package ru.unit.techno.arris.log.action.lib.api;

import ru.unit.techno.arris.log.action.lib.model.ActionObject;

public interface LogAction {
    void logSuccessAction(ActionObject actionObject);

    void logExceptionObject(ActionObject actionObject);
}