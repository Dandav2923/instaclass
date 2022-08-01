package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "comunicazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comunicazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunicazione")
    private int id;
    @Column(name = "data_comunicazione")
    private LocalDate communicationDate;
    @Column(name = "nome_comunicazione")
    private String communicationName;
    @Column(name = "descrizione_comunicazione")
    private String communicationDescription;
    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe communicationClasses;

    public Comunicazione(LocalDate comunicationDate, String comunicationName, String comunicationDescription, Classe comunicationClasses) {
        this.communicationDate = comunicationDate;
        this.communicationName = comunicationName;
        this.communicationDescription = comunicationDescription;
        this.communicationClasses = comunicationClasses;
    }
}
