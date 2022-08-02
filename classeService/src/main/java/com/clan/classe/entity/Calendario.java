package com.clan.classe.entity;

import lombok.*;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "calendari")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendario {
    @Id
    @SequenceGenerator(name = "id_calendar_generator", sequenceName = "id_calendar_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_calendar_generator")
    @Column(name = "id_calendario")
    private Integer id;

    @Column(name = "data_evento", nullable = false)
    private LocalDate EventDate;

    @Column(name = "nome_evento", nullable = false)
    private String EventName;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_classe")
    private Classe calendarClass;

    public Calendario(LocalDate eventDate, String eventName, Classe calendarClass) {
        EventDate = eventDate;
        EventName = eventName;
        this.calendarClass = calendarClass;
    }
}
