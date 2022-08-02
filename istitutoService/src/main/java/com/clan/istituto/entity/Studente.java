package com.clan.istituto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "studenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studente {
    @Id
    @SequenceGenerator(name = "studente_generator", sequenceName = "studente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studente_generator")
    @Column(name = "id_studente")
    private int id;
    @Column(name = "nome_studente",columnDefinition = "varchar(100)",nullable = false)
    private String nameStudent;
    @Column(name = "cognome_studente",columnDefinition = "varchar(100)",nullable = false)
    private String  surnameStudent;
    @Column(name = "codice_fiscale", columnDefinition = "CHAR(16)",nullable = false)
    private String cFStudent;
    @Column(name = "password_studente",columnDefinition = "varchar(100)",nullable = false)
    private String passwordStudent;
    @ManyToMany(mappedBy = "listIstituteStudent",fetch = FetchType.LAZY)
    private Set<Istituto> listStudentIstitute;


}
