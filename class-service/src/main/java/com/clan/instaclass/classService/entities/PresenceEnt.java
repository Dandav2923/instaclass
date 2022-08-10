package com.clan.instaclass.classService.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "presence")
public class PresenceEnt implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "present", nullable = false)
    private Boolean present;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "student_id", nullable = false)
    private Integer student;

    @ManyToOne
    @JoinColumn(name="class_id", nullable = false)
    private ClassEnt classEnt;
}
