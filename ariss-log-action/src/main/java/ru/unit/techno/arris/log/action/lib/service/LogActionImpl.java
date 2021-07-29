
package ru.unit.techno.arris.log.action.lib.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.unit.techno.arris.log.action.lib.api.LogAction;
import ru.unit.techno.arris.log.action.lib.config.DeviceEventConfig;
import ru.unit.techno.arris.log.action.lib.entity.Event;
import ru.unit.techno.arris.log.action.lib.model.ActionObject;
import ru.unit.techno.arris.log.action.lib.model.EntryType;
import ru.unit.techno.arris.log.action.lib.model.MetaObject;
import ru.unit.techno.arris.log.action.lib.repository.EventRepository;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LogActionImpl implements LogAction {

    private final DeviceEventConfig deviceEventConfig;
    private final EventRepository eventRepository;

    @Override
    @Transactional
    public void logSuccessAction(ActionObject actionObject) {
        Map<Long, MetaObject> type = deviceEventConfig.getType();

        MetaObject metaObject = Optional.ofNullable(type.get(actionObject.getDeviceId()))
                .orElse(new MetaObject()
                        .setEntryType(EntryType.UNKNOWN)
                        .setInfo(""));

        eventRepository.save(new Event()
                .setCommonId(actionObject.getRfidLabelValue())
                .setEntryDeviceValue(actionObject.getDeviceId())
                .setEventTime(actionObject.getEventTime())
                .setEventType(metaObject.getEntryType().getValue())
                .setGosNumber(actionObject.getGosNumber())
                .setInfo(metaObject.getInfo())
                .setStateOfAction(actionObject.getActionStatus().getValue())
        );
    }

    @Override
    public void logExceptionObject(ActionObject actionObject) {
        eventRepository.save(new Event()
                .setCommonId(actionObject.getRfidLabelValue())
                .setEntryDeviceValue(actionObject.getDeviceId())
                .setEventTime(actionObject.getEventTime())
                .setEventType(null)
                .setGosNumber(actionObject.getGosNumber())
                .setInfo(null)
                .setStateOfAction(actionObject.getActionStatus().getValue())
        );
    }
}