
package ru.unit.techno.arris.log.action.test.module.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import ru.unit.techno.ariss.log.action.lib.dto.ActionDto;
import ru.unit.techno.ariss.log.action.lib.entity.Description;
import ru.unit.techno.ariss.log.action.lib.entity.Event;
import ru.unit.techno.arris.log.action.test.module.base.BaseTestClass;
import ru.unit.techno.arris.log.action.test.module.base.RestPageImpl;

import java.time.LocalDateTime;
import java.util.List;

public class ActionResourceTest extends BaseTestClass {

    @Test
    public void testFilteringByInfo() {
        eventRepository.saveAll(List.of(
                new Event()
                        .setId(1L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 12, 12))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description()),
                new Event()
                        .setId(2L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 12, 12))
                        .setEventType("IN")
                        .setInfo("unknown")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description())
        ));

        RestPageImpl<ActionDto> result = testUtils.invokeGetApi(new ParameterizedTypeReference<RestPageImpl<ActionDto>>() {
        }, "/ui/actions?info=info", HttpStatus.OK);
        assertEquals(result.getContent().size(), 1);
        assertEquals(result.getContent().get(0).getId(), 2L);
    }

    @Test
    public void testFilteringByDate() {
        eventRepository.saveAll(List.of(
                new Event()
                        .setId(1L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 12, 12))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description()),
                new Event()
                        .setId(2L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2024, 12, 5, 12, 12))
                        .setEventType("IN")
                        .setInfo("unknown")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description())
        ));

        RestPageImpl<ActionDto> result = testUtils.invokeGetApi(new ParameterizedTypeReference<RestPageImpl<ActionDto>>() {
        }, "/ui/actions?event_time=2023-12-11", HttpStatus.OK);
        assertEquals(result.getContent().size(), 1);
    }

    @Test
    public void testFilteringByInfoWithSort() {
        eventRepository.saveAll(List.of(
                new Event()
                        .setId(1L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 12, 12))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description()),
                new Event()
                        .setId(2L)
                        .setCommonId(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 7, 12, 12))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description())
        ));

        RestPageImpl<ActionDto> result = testUtils.invokeGetApi(new ParameterizedTypeReference<RestPageImpl<ActionDto>>() {
        }, "/ui/actions?sort=eventTime,desc", HttpStatus.OK);
        assertEquals(result.getContent().get(0).getEventTime(), LocalDateTime.of(2021, 12, 7, 12, 12));
    }
}