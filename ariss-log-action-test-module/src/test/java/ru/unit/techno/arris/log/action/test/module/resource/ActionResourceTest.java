
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

    public static final String BASE_URL = "ariss-log-action-test-application";

    @Test
    public void testFilteringByInfo() {
        eventRepository.saveAll(List.of(
                new Event()
                        .setId(1L)
                        .setRfidLabelValue(123124L)
                        .setDeviceId(12412L)
                        .setEventTime(LocalDateTime.of(2021, 12, 5, 12, 12))
                        .setEventType("IN")
                        .setInfo("info")
                        .setStateOfAction("ACTIVE")
                        .setGosNumber("А456ВГ")
                        .setDescription(new Description())
        ));

        RestPageImpl<ActionDto> result = testUtils.invokeGetApi(new ParameterizedTypeReference<RestPageImpl<ActionDto>>() {
        }, BASE_URL + "/ui/actions?info=info", HttpStatus.OK);
        assertEquals(result.getContent().size(), 1);
    }
}