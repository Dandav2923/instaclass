package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    @Column(name = "nome_materia",columnDefinition = "varchar(100)",nullable = false)
    private String nameMatter;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "fk_istituto",nullable = false)
    private Istituto matterIstitute;

    @ManyToMany(mappedBy = "listTeacherMatter",fetch = FetchType.LAZY)
    private Set<Docente> listMatterTeacher;

}
