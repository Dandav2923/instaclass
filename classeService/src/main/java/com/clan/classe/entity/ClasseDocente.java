package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "classi_docenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClasseDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe_docente")
    private int id;
    @Column(name = "docente_fk")
    private Integer studenteFk;
    @ManyToOne
    @JoinColumn(name = "classe_fk")
    private Classe classeDocenteFk;


    public ClasseDocente(Integer studenteFk, Classe classeDocenteFk) {
        this.studenteFk = studenteFk;
        this.classeDocenteFk = classeDocenteFk;
    }
}
