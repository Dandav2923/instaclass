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
    private Integer teacherFk;
    @ManyToOne
    @JoinColumn(name = "classe_fk")
    private Classe classTeacherFk;

    public ClasseDocente(Integer teacherFk, Classe classTeacherFk) {
        this.teacherFk = teacherFk;
        this.classTeacherFk = classTeacherFk;
    }
}
