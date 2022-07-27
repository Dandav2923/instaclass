package com.clan.istituto.entity;

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
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private int id;
    @Column(name = "nome_materia")
    private String nomeMateria;
    @OneToMany(mappedBy = "materiaVoto")
    private List<Voto> listaMaterieVoti = new ArrayList<Voto>();

    @ManyToMany(mappedBy = "listaIstitutiMaterie")
    private List<Istituto> listaMaterieIstituti = new ArrayList<Istituto>();

    @ManyToMany(mappedBy = "listaDocentiMaterie")
    private List<Docente> listaMaterieDocenti = new ArrayList<Docente>();

    public Materia(String nomeMateria, List<Voto> listaMaterieVoti, List<Istituto> listaMaterieIstituti, List<Docente> listaMaterieDocenti) {
        this.nomeMateria = nomeMateria;
        this.listaMaterieVoti = listaMaterieVoti;
        this.listaMaterieIstituti = listaMaterieIstituti;
        this.listaMaterieDocenti = listaMaterieDocenti;
    }

    public Materia(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }
}
