package com.clan.instaclass.classService.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "homework")
public class HomeworkEnt implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "assignment", nullable = false)
    private String assignment;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "subject_id", nullable = false)
    private Integer subject;

    @ManyToOne
    @JoinColumn(name="class_id", nullable = false)
    private ClassEnt classEnt;
}
