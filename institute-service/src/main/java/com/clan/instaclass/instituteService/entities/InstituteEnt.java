package com.clan.instaclass.instituteService.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "institute")
public class InstituteEnt implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "INSTITUTE_SEQ_GEN", sequenceName = "institute_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTITUTE_SEQ_GEN")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "institute")
    private Set<StudentEnt> students;

    @OneToMany(mappedBy = "institute")
    private Set<SubjectEnt> subjects;

    @OneToMany(mappedBy = "institute")
    private Set<TeacherEnt> teachers;
}
