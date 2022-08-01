package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "voti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private int id;
    @Column(name = "punteggio")
    private Integer punteggioVoto;

    @Column(name = "fk_materia")
    private Integer matterFK;

    @Column(name = "fk_studente")
    private Integer studentFK;

    public Vote(Integer punteggioVoto, Integer matterFK, Integer studentFK) {
        this.punteggioVoto = punteggioVoto;
        this.matterFK = matterFK;
        this.studentFK = studentFK;
    }
}
