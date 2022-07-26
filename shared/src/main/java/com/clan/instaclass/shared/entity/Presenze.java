package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "presenze")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Presenze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenza")
    private int id;
    @Column(name = "data_giorno")
    private LocalDate dataGiorno;
    private Boolean presente;

    @ManyToOne
    @JoinColumn(name = "fk_studente")
    private Studenti studentePresenze;

    public Presenze(LocalDate data_giorno, Boolean presente, Studenti studente) {
        this.dataGiorno = data_giorno;
        this.presente = presente;
        this.studentePresenze = studente;
    }
}
