package com.clan.classe.entity;

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
    @ManyToOne
    @JoinColumn(name = "classe_fk")
    private Classe classeStudenteFk;

    public ClasseStudente(Integer studenteFk, Classe classeStudenteFk) {
        this.studenteFk = studenteFk;
        this.classeStudenteFk = classeStudenteFk;
    }
}

