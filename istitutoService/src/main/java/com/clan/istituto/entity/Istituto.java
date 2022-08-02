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
@Table(name = "istituti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Istituto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_istituto")
    private Integer id;
    @Column(name = "nome_istituto",columnDefinition = "varchar(100)",nullable = false)
    private String nameIstitute;
    @Column(name = "password_istituto",columnDefinition = "varchar(100)",nullable = false)
    private String  passwordIstitute;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "istituti_studenti",
            joinColumns = @JoinColumn(name = "istituto_fk",referencedColumnName = "id_istituto",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "studente_fk",referencedColumnName = "id_studente",nullable = false)
    )
    private Set<Studente> listIstituteStudent;

    @OneToMany(mappedBy = "matterIstitute",fetch = FetchType.LAZY)
    private Set<Materia> listIstituteMatter;

    @OneToMany(mappedBy = "teacherIstitute",fetch = FetchType.LAZY)
    private Set<Docente> listIstituteTeacher;

}
