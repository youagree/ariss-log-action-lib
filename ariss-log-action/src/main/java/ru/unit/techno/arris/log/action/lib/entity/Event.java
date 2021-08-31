package ru.unit.techno.arris.log.action.lib.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "events")
@Accessors(chain = true)
@SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    private Long id;

    @Column(name = "rfid_label_value")
    private Long rfidLabelValue;

    @Column(name = "entry_device_value")
    private Long deviceId;

    @Column(name = "event_time")
    private LocalDateTime eventTime;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "info")
    private String info;

    @Column(name = "state_of_action")
    private String stateOfAction;

    @Column(name = "gos_number")
    private String gosNumber;

    @Column(name = "is_errored")
    private boolean isErrored;

    @Type(type = "jsonb")
    @Column(name = "description", columnDefinition = "jsonb")
    private Description description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Event event = (Event) o;

        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return 1491041522;
    }
}
