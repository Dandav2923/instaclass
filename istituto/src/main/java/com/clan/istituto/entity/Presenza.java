package com.clan.istituto.entity;

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
public class Presenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenza")
    private int id;
    @Column(name = "data_giorno")
    private LocalDate dataGiorno;
    private Boolean presente;

    @ManyToOne
    @JoinColumn(name = "fk_studente")
    private Studente studentePresenze;

    public Presenza(LocalDate data_giorno, Boolean presente, Studente studente) {
        this.dataGiorno = data_giorno;
        this.presente = presente;
        this.studentePresenze = studente;
    }


}
