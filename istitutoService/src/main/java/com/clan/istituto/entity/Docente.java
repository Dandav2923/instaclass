package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private int id;
    @Column(name = "codice_fiscale", columnDefinition = "bpchar")
    private String cFTeacher;
    @Column(name = "nome_docente")
    private String  nameTeacher;
    @Column(name = "cognome_docente")
    private String surnameTeacher;
    @Column(name = "password_docente")
    private String passwordTeacher;

    @ManyToMany
    @JoinTable(name = "docenti_materie" , joinColumns = @JoinColumn(name = "materia_fk"), inverseJoinColumns = @JoinColumn(name = "docente_fk"))
    private List<Materia> listTeacherMatter = new ArrayList<Materia>();

    @ManyToMany(mappedBy = "listIstituteTeacher")
    private List<Istituto> listTeacherIstitute = new ArrayList<Istituto>();


}
