package com.clan.instaclass.classService.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "class_student", uniqueConstraints = {
        @UniqueConstraint(
                name = "UniqueStudentClass",
                columnNames = {
                        "student_id",
                        "class_id"
                })
})
public class ClassStudentRel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "student_id", nullable = false)
    private Integer student;

    @ManyToOne
    @JoinColumn(name="class_id", nullable = false)
    private ClassEnt classEnt;
}
