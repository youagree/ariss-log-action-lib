
package ru.unit.techno.ariss.log.action.lib.mapper;

import org.mapstruct.Mapper;
import ru.unit.techno.ariss.log.action.lib.dto.ActionDto;
import ru.unit.techno.ariss.log.action.lib.entity.Event;

@Mapper
public interface ActionMapper {
    ActionDto toDto(Event event);
}