package com.clan.instaclass.classService.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "class_teacher", uniqueConstraints = {
        @UniqueConstraint(
                name = "UniqueTeacherSubjectClass",
                columnNames = {
                        "teacher_id",
                        "subject_id",
                        "class_id"
                })
})
public class ClassTeacherRel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "teacher_id", nullable = false)
    private Integer teacher;

    @Column(name = "subject_id", nullable = false)
    private Integer subject;

    @ManyToOne
    @JoinColumn(name="class_id", nullable = false)
    private ClassEnt classEnt;
}
