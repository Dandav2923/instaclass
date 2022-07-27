package com.clan.instaclass.shared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "materie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private int id;
    @Column(name = "nome")
    private String nomeMateria;
    @OneToMany(mappedBy = "materiaVoto")
    private List<Voti> listaMaterieVoti = new ArrayList<Voti>();

    @ManyToMany(mappedBy = "listaIstitutiMaterie")
    private List<Istituti> listaMaterieIstituti = new ArrayList<Istituti>();

    @ManyToMany(mappedBy = "listaDocentiMaterie")
    private List<Docenti> listaMaterieDocenti = new ArrayList<Docenti>();

    public Materie(String nomeMateria, List<Voti> listaMaterieVoti, List<Istituti> listaMaterieIstituti, List<Docenti> listaMaterieDocenti) {
        this.nomeMateria = nomeMateria;
        this.listaMaterieVoti = listaMaterieVoti;
        this.listaMaterieIstituti = listaMaterieIstituti;
        this.listaMaterieDocenti = listaMaterieDocenti;
    }

    public Materie(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }
}
