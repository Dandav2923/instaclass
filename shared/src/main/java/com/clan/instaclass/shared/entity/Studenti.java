package com.clan.instaclass.shared.entity;

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
public class Studenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studente")
    private int id;
    @Column(name = "nome_studente")
    private String nomeStudente;
    @Column(name = "cognome_studente")
    private String  cognomeStudente;
    @Column(name = "cf", columnDefinition = "bpchar")
    private String codiceFiscaleStudente;
    @Column(name = "password")
    private String passwordStudente;
    @ManyToMany(mappedBy = "listaClassiStudenti")
    private List<Classi> listaStudentiClassi = new ArrayList<Classi>();
    @ManyToMany(mappedBy = "listaIstitutiStudenti")
    private List<Istituti> listaStudentiistituti = new ArrayList<Istituti>();

    @OneToMany(mappedBy = "studentePresenze")
    private List<Presenze> listaStudentiPresenze = new ArrayList<Presenze>();

    @OneToMany(mappedBy = "studenteVoto")
    private List<Voti> listaStudentiVoti = new ArrayList<Voti>();

    public Studenti(String nomeStudente, String cognomeStudente, String cf, String passwordStudente) {
        this.nomeStudente = nomeStudente;
        this.cognomeStudente = cognomeStudente;
        this.codiceFiscaleStudente = cf;
        this.passwordStudente = passwordStudente;
    }

    public Studenti(String nomeStudente, String cognomeStudente, String codiceFiscaleStudente, String passwordStudente, List<Classi> listaStudentiClassi, List<Istituti> listaStudentiistituti, List<Presenze> listaStudentiPresenze, List<Voti> listaStudentiVoti) {
        this.nomeStudente = nomeStudente;
        this.cognomeStudente = cognomeStudente;
        this.codiceFiscaleStudente = codiceFiscaleStudente;
        this.passwordStudente = passwordStudente;
        this.listaStudentiClassi = listaStudentiClassi;
        this.listaStudentiistituti = listaStudentiistituti;
        this.listaStudentiPresenze = listaStudentiPresenze;
        this.listaStudentiVoti = listaStudentiVoti;
    }
}
