package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "istituti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Istituti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_istituto")
    private int id;
    @Column(name = "nome_istituto")
    private String nomeIstituto;
    @Column(name = "password")
    private String  passwordIstituto;
    @OneToMany(mappedBy = "classeIstituto")
    private List<Classi> listaIstitutiClassi = new ArrayList<Classi>();
    @ManyToMany
    @JoinTable(name = "istituti_studenti", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "studente_fk"))
    private List<Studenti> listaIstitutiStudenti = new ArrayList<Studenti>();
    @ManyToMany
    @JoinTable(name = "istituti_materie", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "materia_fk"))
    private List<Materie> listaIstitutiMaterie = new ArrayList<Materie>();
    @ManyToMany
    @JoinTable(name = "docenti_istituti", joinColumns = @JoinColumn(name = "istituto_fk"), inverseJoinColumns = @JoinColumn(name = "docente_fk"))
    private List<Docenti> listaDocentiIstituti = new ArrayList<Docenti>();

    public Istituti(String nomeIstituto, String password) {
        this.nomeIstituto = nomeIstituto;
        this.passwordIstituto = password;
    }
}
