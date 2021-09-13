package ru.unit.techno.ariss.log.action.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unit.techno.ariss.log.action.lib.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
