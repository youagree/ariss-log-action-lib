package ru.unit.techno.ariss.log.action.lib.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

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

    @Column(name = "common_id")
    private Long commonId;

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
}
