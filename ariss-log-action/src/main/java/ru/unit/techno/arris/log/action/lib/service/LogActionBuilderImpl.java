
package ru.unit.techno.arris.log.action.lib.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.unit.techno.arris.log.action.lib.api.LogAction;
import ru.unit.techno.arris.log.action.lib.api.LogActionBuilder;
import ru.unit.techno.arris.log.action.lib.entity.Description;
import ru.unit.techno.arris.log.action.lib.model.ActionObject;
import ru.unit.techno.arris.log.action.lib.model.ActionStatus;

import java.time.LocalDateTime;

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
                .setDeviceId(deviceId)
                .setActionStatus(actionStatus)
                .setEventTime(LocalDateTime.now())
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
                .setEventTime(LocalDateTime.now())
                .setDeviceId(deviceId)
                .setGosNumber(gosNumber)
                .setIsErrored(isErrored)
                .setDescription(description));
    }
}