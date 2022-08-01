package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private Integer id;
    @Column(name = "nome_classe")
    private String className;
    @Column(name = "fk_istituto")
    private Integer istituteFk;

    @OneToMany(mappedBy = "calendarClass")
    private List<Calendario> listClassesCalendar = new ArrayList<Calendario>();
    @OneToMany(mappedBy = "noteClass")
    private List<Nota> listClassesNote = new ArrayList<Nota>();
    @OneToMany(mappedBy = "communicationClasses")
    private List<Comunicazione> listComunicationClasses = new ArrayList<Comunicazione>();
    @OneToMany(mappedBy = "taskClass")
    private List<Compito> listClassesTask = new ArrayList<Compito>();

    @OneToMany(mappedBy = "classStudentFk")
    private List<ClasseStudente> listaClassesStudent = new ArrayList<ClasseStudente>();

    @OneToMany(mappedBy = "classTeacherFk")
    private List<ClasseDocente> listClassesTeacher = new ArrayList<ClasseDocente>();

    public Classe(String className, Integer istituteFk) {
        this.className = className;
        this.istituteFk = istituteFk;
    }
}
