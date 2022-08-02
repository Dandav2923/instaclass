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
    @SequenceGenerator(name = "id_task_generator", sequenceName = "id_task_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_task_generator")
    @Column(name = "id_compito")
    private Integer id;
    @Column(name = "data_consegna", nullable = false)
    private LocalDate deliveryDate;
    @Column(name = "descrizione", nullable = false)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_classe")
    private Classe taskClass;

    public Compito(LocalDate deliveryDate, String description, Classe taskClass) {
        this.deliveryDate = deliveryDate;
        this.description = description;
        this.taskClass = taskClass;
    }
}
