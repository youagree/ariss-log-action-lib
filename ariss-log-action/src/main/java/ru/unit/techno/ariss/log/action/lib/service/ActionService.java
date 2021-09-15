
package ru.unit.techno.ariss.log.action.lib.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.unit.techno.ariss.log.action.lib.dto.ActionDto;
import ru.unit.techno.ariss.log.action.lib.entity.Event;
import ru.unit.techno.ariss.log.action.lib.mapper.ActionMapper;
import ru.unit.techno.ariss.log.action.lib.repository.EventRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActionService {
    private final EventRepository eventRepository;
    private final ActionMapper actionMapper;

    public Page<ActionDto> getActionsWithFilter(Specification<Event> eventSpecification, Pageable pageable) {
        Page<Event> result = eventRepository.findAll(eventSpecification, pageable);

        return new PageImpl<>(result.getContent().stream()
                .map(actionMapper::toDto)
                .collect(Collectors.toList()), pageable, result.getTotalElements());
    }
}