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
    private LocalDate noteDate;
    @Column(name = "descrizione_nota")
    private String noteDescription;
    @Column(name = "cf_studente", columnDefinition = "bpchar")
    private String studentFiscalCode;
    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe noteClass;

    public Nota(LocalDate noteDate, String noteDescription, String studentFiscalCode, Classe noteClasse) {
        this.noteDate = noteDate;
        this.noteDescription = noteDescription;
        this.studentFiscalCode = studentFiscalCode;
        this.noteClass = noteClasse;
    }

    public Nota(LocalDate noteDate, String noteDescription, Classe noteClasse) {
        this.noteDate = noteDate;
        this.noteDescription = noteDescription;
        this.noteClass = noteClasse;
    }
}
