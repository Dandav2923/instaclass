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
    @SequenceGenerator(name = "id_communication_generator", sequenceName = "id_communication_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_communication_generator")
    @Column(name = "id_comunicazione")
    private Integer id;
    @Column(name = "data_comunicazione", nullable = false)
    private LocalDate communicationDate;
    @Column(name = "nome_comunicazione", nullable = false)
    private String communicationName;
    @Column(name = "descrizione_comunicazione")
    private String communicationDescription;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_classe")
    private Classe communicationClasses;

    public Comunicazione(LocalDate comunicationDate, String comunicationName, String comunicationDescription, Classe comunicationClasses) {
        this.communicationDate = comunicationDate;
        this.communicationName = comunicationName;
        this.communicationDescription = comunicationDescription;
        this.communicationClasses = comunicationClasses;
    }
}
