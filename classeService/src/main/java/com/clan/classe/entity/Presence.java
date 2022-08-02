package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "presenze")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Presence {
    @Id
    @SequenceGenerator(name = "id_presence_generator", sequenceName = "id_presence_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_presence_generator")
    @Column(name = "id_presenza")
    private Integer id;
    @Column(name = "data_giorno", nullable = false)
    private LocalDate day;
    @Column(name = "presente", nullable = false)
    private Boolean isPresent;

    @Column(name = "fk_studente", nullable = false)
    private Integer studentFK;

    public Presence(LocalDate day, Boolean isPresent, Integer studentFK) {
        this.day = day;
        this.isPresent = isPresent;
        this.studentFK = studentFK;
    }
}
