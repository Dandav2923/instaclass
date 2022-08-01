package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studente")
    private int id;
    @Column(name = "nome_studente")
    private String nameStudent;
    @Column(name = "cognome_studente")
    private String  surnameStudent;
    @Column(name = "codice_fiscale", columnDefinition = "bpchar")
    private String cFStudent;
    @Column(name = "password_studente")
    private String passwordStudent;
    @ManyToMany(mappedBy = "listIstituteStudent")
    private List<Istituto> listStudentIstitute = new ArrayList<Istituto>();

    public Studente(String nameStudent, String surnameStudent, String cFStudent, String passwordStudent) {
        this.nameStudent = nameStudent;
        this.surnameStudent = surnameStudent;
        this.cFStudent = cFStudent;
        this.passwordStudent = passwordStudent;
    }

    public Studente(String nameStudent, String surnameStudent, String cFStudent, String passwordStudent, List<Istituto> listStudentIstituto) {
        this.nameStudent = nameStudent;
        this.surnameStudent = surnameStudent;
        this.cFStudent = cFStudent;
        this.passwordStudent = passwordStudent;
        this.listStudentIstitute = listStudentIstituto;
    }
}
