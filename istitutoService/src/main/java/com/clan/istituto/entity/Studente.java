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
    private String nomeStudente;
    @Column(name = "cognome_studente")
    private String  cognomeStudente;
    @Column(name = "codice_fiscale", columnDefinition = "bpchar")
    private String codiceFiscaleStudente;
    @Column(name = "password_studente")
    private String passwordStudente;
    @ManyToMany(mappedBy = "listaIstitutiStudenti")
    private List<Istituto> listaStudentiistituti = new ArrayList<Istituto>();

    @OneToMany(mappedBy = "studentePresenze")
    private List<Presenza> listaStudentiPresenze = new ArrayList<Presenza>();

    @OneToMany(mappedBy = "studenteVoto")
    private List<Voto> listaStudentiVoti = new ArrayList<Voto>();

    public Studente(String nomeStudente, String cognomeStudente, String cf, String passwordStudente) {
        this.nomeStudente = nomeStudente;
        this.cognomeStudente = cognomeStudente;
        this.codiceFiscaleStudente = cf;
        this.passwordStudente = passwordStudente;
    }

    public Studente(String nomeStudente, String cognomeStudente, String codiceFiscaleStudente, String passwordStudente, List<Istituto> listaStudentiIstituti, List<Presenza> listaStudentiPresenze, List<Voto> listaStudentiVoti) {
        this.nomeStudente = nomeStudente;
        this.cognomeStudente = cognomeStudente;
        this.codiceFiscaleStudente = codiceFiscaleStudente;
        this.passwordStudente = passwordStudente;
        this.listaStudentiistituti = listaStudentiIstituti;
        this.listaStudentiPresenze = listaStudentiPresenze;
        this.listaStudentiVoti = listaStudentiVoti;
    }
}
