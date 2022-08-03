package com.clan.instaclass.classService.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "vote")
public class VoteEnt implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vote", nullable = false, length = 100)
    private Integer vote;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "student_id", nullable = false)
    private Integer student;

    @Column(name = "subject_id", nullable = false)
    private Integer subject;

    @Column(name = "teacher_id", nullable = false)
    private Integer teacher;

    @ManyToOne
    @JoinColumn(name="class_id", nullable = false)
    private ClassEnt classEnt;
}
