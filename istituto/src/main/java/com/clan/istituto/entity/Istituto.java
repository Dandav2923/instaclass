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
    private String nomeIstituto;
    @Column(name = "password_istituto")
    private String  passwordIstituto;


    @ManyToMany
    @JoinTable(name = "istituti_studenti", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "studente_fk"))
    private List<Studente> listaIstitutiStudenti = new ArrayList<Studente>();

    @ManyToMany
    @JoinTable(name = "istituti_materie", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "materia_fk"))
    private List<Materia> listaIstitutiMaterie = new ArrayList<Materia>();

    @ManyToMany
    @JoinTable(name = "docenti_istituti", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "docente_fk"))
    private List<Docente> listaIstitutiDocenti = new ArrayList<Docente>();

    public Istituto(String nomeIstituto, String passwordIstituto) {
        this.nomeIstituto = nomeIstituto;
        this.passwordIstituto = passwordIstituto;
    }
}
