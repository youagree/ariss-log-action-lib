package ru.unit.techno.arris.log.action.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.unit.techno.arris.log.action.lib.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
