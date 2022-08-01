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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenza")
    private int id;
    @Column(name = "data_giorno")
    private LocalDate day;
    @Column(name = "presente")
    private Boolean isPresent;

    @Column(name = "fk_studente")
    private Integer studentFK;

    public Presence(LocalDate day, Boolean isPresent, Integer studentFK) {
        this.day = day;
        this.isPresent = isPresent;
        this.studentFK = studentFK;
    }
}
