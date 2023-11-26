package org.fastcampus.project.student.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.base.db.AuditingField;
import org.fastcampus.project.school.db.model.School;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Slf4j
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Student extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String majorSubject;

    @ManyToOne(optional = false)
    private School school;

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<StudentSubject> subjects = new ArrayList<>();

    private Student(Long id, String name, String majorSubject, School school) {
        this.id = id;
        this.name = name;
        this.majorSubject = majorSubject;
        this.school = school;
    }

    public static Student of(Long id, String name, String majorSubject, School school) {
        return new Student(id, name, majorSubject, school);
    }


    protected Student() {
    }
}
