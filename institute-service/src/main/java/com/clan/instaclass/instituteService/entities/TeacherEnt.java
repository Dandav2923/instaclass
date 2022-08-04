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
@Table(name = "teacher", uniqueConstraints = {
        @UniqueConstraint(
                name = "UniqueFiscalCodeAndInstituteTeacher",
                columnNames = {
                        "fiscal_code",
                        "institute_id"
                }),
        @UniqueConstraint(
                name = "UniqueUsernameAndInstituteTeacher",
                columnNames = {
                        "username",
                        "institute_id"
                })
})
public class TeacherEnt implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TEACHER_SEQ_GEN", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEACHER_SEQ_GEN")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "fiscal_code" ,nullable = false)
    private String fiscalCode;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name="institute_id", nullable = false)
    private InstituteEnt institute;

    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "teachers_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<SubjectEnt> subjects;
}
