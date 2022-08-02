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
    @SequenceGenerator(name = "id_note_generator", sequenceName = "id_calendar_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_calendar_generator")
    @Column(name = "id_nota")
    private Integer id;
    @Column(name = "data_nota", nullable = false)
    private LocalDate noteDate;
    @Column(name = "descrizione_nota", nullable = false)
    private String noteDescription;
    @Column(name = "cf_studente", columnDefinition = "CHAR(16)", unique = true)
    private String studentFiscalCode;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
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
