package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "voti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private int id;
    @Column(name = "punteggio")
    private Integer punteggioVoto;

    @ManyToOne
    @JoinColumn(name = "fk_materia")
    private Materie materieVoto;

    @ManyToOne
    @JoinColumn(name = "fk_studente")
    private Studenti studenteVoto;

    public Voti(Integer punteggio, Materie materie, Studenti studenteVoto) {
        this.punteggioVoto = punteggio;
        this.materieVoto = materie;
        this.studenteVoto = studenteVoto;
    }
}
