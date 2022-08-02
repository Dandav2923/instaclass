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
    @SequenceGenerator(name = "id_vote_generator", sequenceName = "id_vote_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_vote_generator")
    @Column(name = "id_voto")
    private Integer id;
    @Column(name = "punteggio", nullable = false)
    private Integer punteggioVoto;

    @Column(name = "fk_materia", nullable = false)
    private Integer matterFK;

    @Column(name = "fk_studente", nullable = false)
    private Integer studentFK;

    public Vote(Integer punteggioVoto, Integer matterFK, Integer studentFK) {
        this.punteggioVoto = punteggioVoto;
        this.matterFK = matterFK;
        this.studentFK = studentFK;
    }
}
