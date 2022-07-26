package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private int id;
    @Column(name = "cf", columnDefinition = "bpchar")
    private String codiceFiscaleDocente;
    @Column(name = "nome_docente")
    private String  nomeDocente;
    @Column(name = "cognome")
    private String cognomeDocente;
    private String password;
    @ManyToMany
    @JoinTable(name = "docenti_materie" , joinColumns = @JoinColumn(name = "materia_fk"), inverseJoinColumns = @JoinColumn(name = "docente_fk"))
    private List<Materie> materieDocenti = new ArrayList<Materie>();
    @ManyToMany
    @JoinTable(name = "classi_docenti" , joinColumns = @JoinColumn(name = "classe_fk"), inverseJoinColumns = @JoinColumn(name = "docente_fk"))
    private List<Classi> listaDocentiClassi = new ArrayList<Classi>();

    @ManyToMany(mappedBy = "listaDocentiIstituti")
    private List<Istituti> listaIstituti = new ArrayList<Istituti>();

    public Docenti(String codiceFiscaleDocente, String nomeDocente, String cognomeDocente, String password, List<Studenti> studenti) {
        this.codiceFiscaleDocente = codiceFiscaleDocente;
        this.nomeDocente = nomeDocente;
        this.cognomeDocente = cognomeDocente;
        this.password = password;
    }
}
