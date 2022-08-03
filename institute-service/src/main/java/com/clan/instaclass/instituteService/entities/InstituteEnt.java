package com.clan.instaclass.instituteService.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name = "name",unique = true, nullable = false)
    private String name;


    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "institute_students",
            joinColumns = @JoinColumn(name = "institute_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<StudentEnt> students;

    @OneToMany(mappedBy = "institute")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SubjectEnt> subjects;

    @OneToMany(mappedBy = "institute")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<TeacherEnt> teachers;
}
