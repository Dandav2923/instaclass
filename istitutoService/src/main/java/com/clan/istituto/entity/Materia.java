package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "materie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private int id;
    @Column(name = "nome_materia")
    private String nameMatter;

    @ManyToMany(mappedBy = "listIstituteMatter")
    private List<Istituto> listMatterIstitute = new ArrayList<Istituto>();

    @ManyToMany(mappedBy = "listTeacherMatter")
    private List<Docente> listMatterTeacher = new ArrayList<Docente>();

    public Materia(String nameMatter, List<Istituto> listMatterIstitute, List<Docente> listaMatterTeacher) {
        this.nameMatter = nameMatter;
        this.listMatterIstitute = listMatterIstitute;
        this.listMatterTeacher = listaMatterTeacher;
    }

    public Materia(int id, String nameMatter) {
        this.id = id;
        this.nameMatter = nameMatter;
    }
}
