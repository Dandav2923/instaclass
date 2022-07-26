package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "compiti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compito")
    private int id;
    @Column(name = "data_consegna")
    private LocalDate dataConsegna;
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classi compitoClasse;

    public Compiti(LocalDate dataConsegna, String descrizione, Classi compitoClasse) {
        this.dataConsegna = dataConsegna;
        this.descrizione = descrizione;
        this.compitoClasse = compitoClasse;
    }
}
