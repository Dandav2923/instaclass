package com.clan.classe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "compiti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compito")
    private int id;
    @Column(name = "data_consegna")
    private LocalDate deliveryDate;
    @Column(name = "descrizione")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_classe")
    private Classe taskClass;

    public Compito(LocalDate deliveryDate, String description, Classe taskClass) {
        this.deliveryDate = deliveryDate;
        this.description = description;
        this.taskClass = taskClass;
    }
}
