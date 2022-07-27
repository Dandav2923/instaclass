package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private int id;
    @Column(name = "nome_classe")
    private String nomeClasse;
    @Column(name = "fk_istituto")
    private Integer istitutoFk;

    @OneToMany(mappedBy = "calendarioClasse")
    private List<Calendario> listaClassiCalendari = new ArrayList<Calendario>();
    @OneToMany(mappedBy = "notaClasse")
    private List<Nota> listaClassiNote = new ArrayList<Nota>();
    @OneToMany(mappedBy = "comunicazioneClasse")
    private List<Comunicazione> listaClassiComunicazioni = new ArrayList<Comunicazione>();
    @OneToMany(mappedBy = "compitoClasse")
    private List<Compito> listaClassiCompiti = new ArrayList<Compito>();


}
