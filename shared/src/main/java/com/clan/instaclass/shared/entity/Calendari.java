package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "calendari")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendario")
    private int id;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Column(name = "nome_evento")
    private String nomeEvento;

    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classi calendarioClasse;

    public Calendari(LocalDate dataEvento, String nomeEvento, Classi calendarioClasse) {
        this.dataEvento = dataEvento;
        this.nomeEvento = nomeEvento;
        this.calendarioClasse = calendarioClasse;
    }
}
