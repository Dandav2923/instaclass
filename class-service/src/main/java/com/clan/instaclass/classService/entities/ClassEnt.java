package com.clan.instaclass.classService.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ClassTeacherRel> teachers;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ClassStudentRel> students;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<VoteEnt> votes;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<StudentNoteEnt> studentsNotes;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ClassNoteEnt> classNotes;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PresenceEnt> presences;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<HomeworkEnt> homeworks;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<CommunicationEnt> communications;

    @OneToMany(mappedBy = "classEnt")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<EventEnt> events;
}
