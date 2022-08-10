package com.clan.instaclass.instituteService.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student",uniqueConstraints = {
        @UniqueConstraint(
                name = "UniqueFiscalCodeAndInstituteStudent",
                columnNames = {
                        "fiscal_code",
                        "institute_id"
                }),
        @UniqueConstraint(
                name = "UniqueUsernameAndInstituteStudent",
                columnNames = {
                        "username",
                        "institute_id"
                })
})
public class StudentEnt implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "STUDENT_SEQ_GEN", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ_GEN")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "fiscal_code", nullable = false)
    private String fiscalCode;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name="institute_id", nullable = false)
    private InstituteEnt institute;
}
