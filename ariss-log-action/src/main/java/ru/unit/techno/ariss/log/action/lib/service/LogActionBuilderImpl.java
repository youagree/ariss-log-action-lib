
package ru.unit.techno.ariss.log.action.lib.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.unit.techno.ariss.log.action.lib.api.LogAction;
import ru.unit.techno.ariss.log.action.lib.api.LogActionBuilder;
import ru.unit.techno.ariss.log.action.lib.model.ActionObject;
import ru.unit.techno.ariss.log.action.lib.model.ActionStatus;
import ru.unit.techno.ariss.log.action.lib.entity.Description;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class LogActionBuilderImpl implements LogActionBuilder {

    private final LogAction logAction;

    @Override
    public void buildActionObjectAndLogAction(Long deviceId,
                                              Long commonId,
                                              String gosNumber,
                                              ActionStatus actionStatus) {
        logAction.logSuccessAction(new ActionObject()
                .setDeviceId(deviceId)
                .setCommonId(commonId)
                .setActionStatus(actionStatus)
                .setEventTime(Calendar.getInstance().getTime())
                .setGosNumber(gosNumber));
    }

    @Override
    public void buildActionObjectAndLogAction(Long deviceId,
                                              Long commonId,
                                              String gosNumber,
                                              ActionStatus actionStatus,
                                              boolean isErrored,
                                              Description description) {
        logAction.logSuccessAction(new ActionObject()
                .setCommonId(commonId)
                .setActionStatus(actionStatus)
                .setEventTime(Calendar.getInstance().getTime())
                .setDeviceId(deviceId)
                .setGosNumber(gosNumber)
                .setIsErrored(isErrored)
                .setDescription(description));
    }
}