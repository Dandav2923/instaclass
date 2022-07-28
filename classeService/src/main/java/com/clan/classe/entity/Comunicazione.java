package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "comunicazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comunicazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunicazione")
    private int id;
    @Column(name = "data_comunicazione")
    private LocalDate dataComunicazione;
    @Column(name = "nome_comunicazione")
    private String nomeComunicazione;
    @Column(name = "descrizione_comunicazione")
    private String descrizioneComunicazione;
    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe comunicazioneClasse;

    public Comunicazione(LocalDate dataComunicazione, String nomeComunicazione, Classe comunicazioneClasse) {
        this.dataComunicazione = dataComunicazione;
        this.nomeComunicazione = nomeComunicazione;
        this.comunicazioneClasse = comunicazioneClasse;
    }
}
