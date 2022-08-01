package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "istituti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Istituto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_istituto")
    private int id;
    @Column(name = "nome_istituto")
    private String nameIstitute;
    @Column(name = "password_istituto")
    private String  passwordIstitute;


    @ManyToMany
    @JoinTable(name = "istituti_studenti", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "studente_fk"))
    private List<Studente> listIstituteStudent = new ArrayList<Studente>();

    @ManyToMany
    @JoinTable(name = "istituti_materie", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "materia_fk"))
    private List<Materia> listIstituteMatter = new ArrayList<Materia>();

    @ManyToMany
    @JoinTable(name = "docenti_istituti", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "docente_fk"))
    private List<Docente> listIstituteTeacher = new ArrayList<Docente>();

    public Istituto(String nameIstitute, String passwordIstitute) {
        this.nameIstitute = nameIstitute;
        this.passwordIstitute = passwordIstitute;
    }

    public Istituto(String nameIstitute, String passwordIstitute, List<Studente> listIstituteStudent, List<Materia> listIstituteMatter, List<Docente> listIstituteTeacher) {
        this.nameIstitute = nameIstitute;
        this.passwordIstitute = passwordIstitute;
        this.listIstituteStudent = listIstituteStudent;
        this.listIstituteMatter = listIstituteMatter;
        this.listIstituteTeacher = listIstituteTeacher;
    }
}
