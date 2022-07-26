package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
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
    private Classi notaClasse;

    public Note(LocalDate dataNota, String descrizioneNota, String cfStudente, Classi notaClasse) {
        this.dataNota = dataNota;
        this.descrizioneNota = descrizioneNota;
        this.cfStudente = cfStudente;
        this.notaClasse = notaClasse;
    }

    public Note(LocalDate dataNota, String descrizioneNota, Classi notaClasse) {
        this.dataNota = dataNota;
        this.descrizioneNota = descrizioneNota;
        this.notaClasse = notaClasse;
    }
}
