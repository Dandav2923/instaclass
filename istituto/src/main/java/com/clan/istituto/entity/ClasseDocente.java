package com.clan.istituto.entity;

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
    @Column(name = "classe_fk")
    private Integer classeFk;

    public ClasseDocente(Integer studenteFk, Integer classeFk) {
        this.studenteFk = studenteFk;
        this.classeFk = classeFk;
    }
}
