package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "classi_studenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClasseStudente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe_studente")
    private int id;
    @Column(name = "studente_fk")
    private Integer studenteFk;
    @Column(name = "classe_fk")
    private Integer classeFk;

    public ClasseStudente(Integer studenteFk, Integer classeFk) {
        this.studenteFk = studenteFk;
        this.classeFk = classeFk;
    }
}
