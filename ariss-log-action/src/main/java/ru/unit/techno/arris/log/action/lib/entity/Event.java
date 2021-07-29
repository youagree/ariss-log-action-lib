package ru.unit.techno.arris.log.action.lib.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "events")
@Accessors(chain = true)
@SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq")
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "squd_event_id_seq")
    private Long id;

    @Column(name = "common_id")
    private Long commonId;

    @Column(name = "entry_device_value")
    private Long entryDeviceValue;

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
}
