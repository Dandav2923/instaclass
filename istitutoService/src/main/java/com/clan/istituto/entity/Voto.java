package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "voti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private int id;
    @Column(name = "punteggio")
    private Integer punteggioVoto;

    @ManyToOne
    @JoinColumn(name = "fk_materia")
    private Materia materiaVoto;

    @ManyToOne
    @JoinColumn(name = "fk_studente")
    private Studente studenteVoto;

    public Voto(Integer punteggio, Materia materie, Studente studenteVoto) {
        this.punteggioVoto = punteggio;
        this.materiaVoto = materie;
        this.studenteVoto = studenteVoto;
    }


}
