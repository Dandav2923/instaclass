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
    @SequenceGenerator(name = "id_class_generator", sequenceName = "id_class_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_class_generator")
    @Column(name = "id_classe")
    private Integer id;
    @Column(name = "nome_classe")
    private String className;
    @Column(name = "fk_istituto")
    private Integer istituteFk;

    @OneToMany(mappedBy = "calendarClass",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Calendario> listClassesCalendar = new ArrayList<Calendario>();
    @OneToMany(mappedBy = "noteClass",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Nota> listClassesNote = new ArrayList<Nota>();
    @OneToMany(mappedBy = "communicationClasses",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comunicazione> listComunicationClasses = new ArrayList<Comunicazione>();
    @OneToMany(mappedBy = "taskClass",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Compito> listClassesTask = new ArrayList<Compito>();
    @OneToMany(mappedBy = "classStudentFk",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ClasseStudente> listaClassesStudent = new ArrayList<ClasseStudente>();
    @OneToMany(mappedBy = "classTeacherFk",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ClasseDocente> listClassesTeacher = new ArrayList<ClasseDocente>();

    public Classe(String className, Integer istituteFk) {
        this.className = className;
        this.istituteFk = istituteFk;
    }
}
