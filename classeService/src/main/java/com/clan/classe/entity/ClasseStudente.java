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
    @SequenceGenerator(name = "id_classStudent_generator", sequenceName = "id_classStudent_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_classStudent_generator")
    @Column(name = "id_classe_studente")
    private int id;
    @Column(name = "studente_fk", nullable = true)
    private Integer studentFk;
    @ManyToOne
    @JoinColumn(name = "classe_fk")
    private Classe classStudentFk;

    public ClasseStudente(Integer studentFk, Classe classStudentFk) {
        this.studentFk = studentFk;
        this.classStudentFk = classStudentFk;
    }
}

