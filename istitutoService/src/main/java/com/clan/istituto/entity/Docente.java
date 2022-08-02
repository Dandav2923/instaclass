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
@Table(name = "docenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer id;
    @Column(name = "codice_fiscale", columnDefinition = "CHAR(16)",nullable = false,unique = true)
    private String cFTeacher;
    @Column(name = "nome_docente",columnDefinition = "varchar(100)",nullable = false)
    private String  nameTeacher;
    @Column(name = "cognome_docente",columnDefinition = "varchar(100)",nullable = false)
    private String surnameTeacher;
    @Column(name = "password_docente",columnDefinition = "varchar(100)",nullable = false)
    private String passwordTeacher;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "docenti_materie",
            joinColumns = @JoinColumn(name = "docente_fk",referencedColumnName = "id_docente",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "materia_fk",referencedColumnName = "id_materia",nullable = false)
    )
    private Set<Materia> listTeacherMatter;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "fk_istituto",nullable = false)
    private Istituto teacherIstitute;


}
