package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "comunicazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comunicazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunicazione")
    private int id;
    @Column(name = "data_comunicazione")
    private LocalDate dataComunicazione;
    @Column(name = "nome_comunicazione")
    private String nomeComunicazione;
    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classi comunicazioneClasse;

    public Comunicazioni(LocalDate dataComunicazione, String nomeComunicazione, Classi comunicazioneClasse) {
        this.dataComunicazione = dataComunicazione;
        this.nomeComunicazione = nomeComunicazione;
        this.comunicazioneClasse = comunicazioneClasse;
    }
}
