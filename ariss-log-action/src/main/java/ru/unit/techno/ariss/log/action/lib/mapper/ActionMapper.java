
package ru.unit.techno.ariss.log.action.lib.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.unit.techno.ariss.log.action.lib.dto.ActionDto;
import ru.unit.techno.ariss.log.action.lib.entity.Event;

import java.time.*;

@Mapper
public interface ActionMapper {

    @Mapping(source = "eventTime", target = "eventTime", qualifiedByName = "mapWithZone")
    ActionDto toDto(Event event);

    @Named(value = "mapWithZone")
    default LocalDateTime mapWithZone(LocalDateTime dateTime) {
        Instant seconds = dateTime.toInstant(ZoneOffset.UTC);
        ZoneId moscowTimeZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime timeWithMoscowZone = seconds.atZone(moscowTimeZone);
        return LocalDateTime.from(timeWithMoscowZone);
    }
}