package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private int id;
    @Column(name = "nome_classe")
    private String nomeClasse;
    @ManyToMany(mappedBy = "listaDocentiClassi")
    private List<Docenti> listaClassiDocenti = new ArrayList<Docenti>();
    @ManyToOne
    @JoinColumn(name = "fk_istituto")
    private Istituti classeIstituto;

    @ManyToMany
    @JoinTable(name = "classi_studenti", joinColumns = @JoinColumn(name = "classe_fk"), inverseJoinColumns = @JoinColumn(name = "studente_fk"))
    private List<Studenti> listaClassiStudenti = new ArrayList<Studenti>();

    @OneToMany(mappedBy = "calendarioClasse")
    private List<Calendari> listaClassiCalendari = new ArrayList<Calendari>();
    @OneToMany(mappedBy = "notaClasse")
    private List<Note> listaClassiNote = new ArrayList<Note>();
    @OneToMany(mappedBy = "comunicazioneClasse")
    private List<Comunicazioni> listaClassiComunicazioni = new ArrayList<Comunicazioni>();
    @OneToMany(mappedBy = "compitoClasse")
    private List<Compiti> listaClassiCompiti = new ArrayList<Compiti>();

    public Classi(String nomeClasse, List<Docenti> listaClassiDocenti, Istituti classeIstituto, List<Studenti> listaClassiStudenti) {
        this.nomeClasse = nomeClasse;
        this.listaClassiDocenti = listaClassiDocenti;
        this.classeIstituto = classeIstituto;
        this.listaClassiStudenti = listaClassiStudenti;
    }
}
