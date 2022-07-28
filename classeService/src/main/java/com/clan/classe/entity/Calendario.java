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
    private LocalDate dataEvento;
    @Column(name = "nome_evento")
    private String nomeEvento;
    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe calendarioClasse;

    public Calendario(LocalDate dataEvento, String nomeEvento, Classe calendarioClasse) {
        this.dataEvento = dataEvento;
        this.nomeEvento = nomeEvento;
        this.calendarioClasse = calendarioClasse;
    }
}
