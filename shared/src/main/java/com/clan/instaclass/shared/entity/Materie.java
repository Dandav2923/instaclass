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
    @OneToMany(cascade =  {CascadeType.REMOVE}, mappedBy = "materieVoto")
    private List<Voti> voti = new ArrayList<Voti>();
    @ManyToMany(mappedBy = "listaIstitutiMaterie")
    private List<Istituti> listaIstituti = new ArrayList<Istituti>();
    @ManyToMany(mappedBy = "materieDocenti")
    private List<Docenti> listaDocenti = new ArrayList<Docenti>();
    public Materie(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }
}
