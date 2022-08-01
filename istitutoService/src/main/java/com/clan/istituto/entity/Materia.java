package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "materie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materia {
    @Id
    @SequenceGenerator(name = "materia_generator", sequenceName = "materia_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_generator")
    @Column(name = "id_materia")
    private int id;
    @Column(name = "nome_materia",columnDefinition = "varchar(100)",nullable = false)
    private String nameMatter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_istitute",nullable = false)
    private Istituto MatterIstitute;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listTeacherMatter")
    private Set<Docente> listMatterTeacher;

}
