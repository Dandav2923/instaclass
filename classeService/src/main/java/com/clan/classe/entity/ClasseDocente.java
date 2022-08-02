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
    @SequenceGenerator(name = "id_classTeacher_generator", sequenceName = "id_classTeacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_classTeacher_generator")
    @Column(name = "id_classe_docente")
    private Integer id;
    @Column(name = "docente_fk", nullable = false)
    private Integer teacherFk;
    @ManyToOne
    @JoinColumn(name = "classe_fk")
    private Classe classTeacherFk;

    public ClasseDocente(Integer teacherFk, Classe classTeacherFk) {
        this.teacherFk = teacherFk;
        this.classTeacherFk = classTeacherFk;
    }
}
