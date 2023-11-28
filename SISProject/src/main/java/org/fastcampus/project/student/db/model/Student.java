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
import java.util.Objects;

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

    private Long majorSubject;

    @ManyToOne(optional = false)
    private School school;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<StudentSubject> subjects = new ArrayList<>();

    private Student(String name, Long majorSubject, School school) {
        this.name = name;
        this.majorSubject = majorSubject;
        this.school = school;
    }

    public static Student of(String name, Long majorSubject, School school) {
        return new Student(name, majorSubject, school);
    }


    protected Student() {
    }
}
