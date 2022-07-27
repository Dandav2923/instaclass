package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "compiti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compito")
    private int id;
    @Column(name = "data_consegna")
    private LocalDate dataConsegna;
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe compitoClasse;

    public Compito(LocalDate dataConsegna, String descrizione, Classe compitoClasse) {
        this.dataConsegna = dataConsegna;
        this.descrizione = descrizione;
        this.compitoClasse = compitoClasse;
    }
}
