
package ru.unit.techno.arris.log.action.test.module.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import ru.unit.techno.ariss.log.action.lib.dto.ActionDto;
import ru.unit.techno.ariss.log.action.lib.entity.Description;
import ru.unit.techno.ariss.log.action.lib.entity.Event;
import ru.unit.techno.arris.log.action.test.module.base.BaseTestClass;
import ru.unit.techno.arris.log.action.test.module.base.RestPageImpl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class ActionResourceTest extends BaseTestClass {

    @Test
    public void testFilteringByInfo() {
        eventRepository.deleteAll();
        Event event = new Event()
                .setCommonId(123124L)
                .setDeviceId(12412L)
                .setEventTime(LocalDateTime.of(2021, 12, 5, 18, 30, 0))
                .setEventType("IN")
                .setInfo("info")
                .setStateOfAction("ACTIVE")
                .setGosNumber("А456ВГ")
                .setDescription(new Description());
        eventRepository.saveAll(List.of(event,
                new Event()
                        .setId(2L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 15, 30, 0))
                        .setEventType("IN")
                        .setInfo("unknown")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description())
        ));

        RestPageImpl<ActionDto> result = testUtils.invokeGetApi(new ParameterizedTypeReference<RestPageImpl<ActionDto>>() {
        }, "/ui/actions?info=info", HttpStatus.OK);
        assertEquals(result.getContent().size(), 1);
        assertEquals(result.getContent().get(0).getId(), event.getId());
    }

    @Test
    public void testFilteringByDate() {
        eventRepository.deleteAll();
        eventRepository.saveAll(List.of(
                new Event()
                        .setId(1L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 4, 56, 0))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description()),
                new Event()
                        .setId(2L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2024, 11, 5, 14, 40, 0))
                        .setEventType("IN")
                        .setInfo("unknown")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description())
        ));

        RestPageImpl<ActionDto> result = testUtils.invokeGetApi(new ParameterizedTypeReference<RestPageImpl<ActionDto>>() {
        }, "/ui/actions?before=2023-11-22T10:00:00&after=2025-12-09T10:00:00", HttpStatus.OK);
        assertEquals(result.getContent().size(), 1);
    }

    @Test
    public void testFilteringByInfoWithSort() {
        eventRepository.deleteAll();
        eventRepository.saveAll(List.of(
                new Event()
                        .setId(1L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 11, 45, 0))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description()),
                new Event()
                        .setId(2L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 7, 5, 33, 0))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description())
        ));

        RestPageImpl<ActionDto> result = testUtils.invokeGetApi(new ParameterizedTypeReference<RestPageImpl<ActionDto>>() {
        }, "/ui/actions?before=2021-12-03T10:00:00&after=2021-12-08T10:00:00&sort=eventTime,desc", HttpStatus.OK);
        assertEquals(result.getContent().get(0).getEventTime(), LocalDateTime.of(2021, 12, 7, 5, 33, 0));
    }

    @Test
    public void testTimeConvert() {
        eventRepository.deleteAll();
        Event event = new Event()
                .setCommonId(123124L)
                .setDeviceId(12412L)
                .setEventTime(LocalDateTime.now())
                .setEventType("IN")
                .setInfo("info")
                .setStateOfAction("ACTIVE")
                .setGosNumber("А456ВГ")
                .setDescription(new Description());

        eventRepository.save(event);
        Event event1 = eventRepository.findAll().get(0);
        ActionDto actionDto = actionMapper.toDto(event1);
        assertNotEquals(event.getEventTime(), actionDto.getEventTime());
    }
}