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
    private String codiceFiscaleDocente;
    @Column(name = "nome_docente")
    private String  nomeDocente;
    @Column(name = "cognome_docente")
    private String cognomeDocente;
    @Column(name = "password_docente")
    private String password;
    @ManyToMany
    @JoinTable(name = "docenti_materie" , joinColumns = @JoinColumn(name = "materia_fk"), inverseJoinColumns = @JoinColumn(name = "docente_fk"))
    private List<Materia> listaDocentiMaterie = new ArrayList<Materia>();

    @ManyToMany(mappedBy = "listaIstitutiDocenti")
    private List<Istituto> listaDocentiIstituti = new ArrayList<Istituto>();

    public Docente(String codiceFiscaleDocente, String nomeDocente, String cognomeDocente, String password) {
        this.codiceFiscaleDocente = codiceFiscaleDocente;
        this.nomeDocente = nomeDocente;
        this.cognomeDocente = cognomeDocente;
        this.password = password;
    }

    public Docente(String codiceFiscaleDocente, String nomeDocente, String cognomeDocente, String password, List<Materia> listaDocentiMaterie,  List<Istituto> listaDocentiIstituti) {
        this.codiceFiscaleDocente = codiceFiscaleDocente;
        this.nomeDocente = nomeDocente;
        this.cognomeDocente = cognomeDocente;
        this.password = password;
        this.listaDocentiMaterie = listaDocentiMaterie;
        this.listaDocentiIstituti = listaDocentiIstituti;
    }
}
