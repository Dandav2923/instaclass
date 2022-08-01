package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "calendari")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendario")
    private int id;
    @Column(name = "data_evento")
    private LocalDate EventDate;
    @Column(name = "nome_evento")
    private String EventName;
    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe calendarClass;

    public Calendario(LocalDate eventDate, String eventName, Classe calendaryClass) {
        EventDate = eventDate;
        EventName = eventName;
        this.calendarClass = calendaryClass;
    }
}
