package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private int id;
    @Column(name = "data_nota")
    private LocalDate dataNota;
    @Column(name = "descrizione_nota")
    private String descrizioneNota;
    @Column(name = "cf_studente", columnDefinition = "bpchar")
    private String cfStudente;
    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe notaClasse;

    public Nota(LocalDate dataNota, String descrizioneNota, String cfStudente, Classe notaClasse) {
        this.dataNota = dataNota;
        this.descrizioneNota = descrizioneNota;
        this.cfStudente = cfStudente;
        this.notaClasse = notaClasse;
    }

    public Nota(LocalDate dataNota, String descrizioneNota, Classe notaClasse) {
        this.dataNota = dataNota;
        this.descrizioneNota = descrizioneNota;
        this.notaClasse = notaClasse;
    }
}
