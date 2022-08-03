package com.clan.instaclass.classService.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "class")
public class ClassEnt implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "institute_id", nullable = false)
    private Integer institute;

    @OneToMany(mappedBy = "classEnt")
    private Set<ClassTeacherRel> teachers;

    @OneToMany(mappedBy = "classEnt")
    private Set<ClassStudentRel> students;

    @OneToMany(mappedBy = "classEnt")
    private Set<VoteEnt> votes;

    @OneToMany(mappedBy = "classEnt")
    private Set<StudentNoteEnt> studentsNotes;

    @OneToMany(mappedBy = "classEnt")
    private Set<ClassNoteEnt> classNotes;

    @OneToMany(mappedBy = "classEnt")
    private Set<PresenceEnt> presences;

    @OneToMany(mappedBy = "classEnt")
    private Set<HomeworkEnt> homeworks;

    @OneToMany(mappedBy = "classEnt")
    private Set<CommunicationEnt> communications;

    @OneToMany(mappedBy = "classEnt")
    private Set<EventEnt> events;
}
