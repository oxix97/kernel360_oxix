package org.fastcampus.project.subject.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.base.db.AuditingField;
import org.fastcampus.project.school.db.model.School;
import org.fastcampus.project.score.db.model.Score;
import org.fastcampus.project.student.db.model.StudentSubject;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
@Entity
@Slf4j
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Subject extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int gradeType;

    @ManyToOne(optional = false)
    private School school;

    @ToString.Exclude
    @OneToMany(mappedBy = "subject")
    private List<StudentSubject> students = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "subject")
    private List<Score> scores = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private Subject(String name, int gradeType, School school) {
        this.name = name;
        this.gradeType = gradeType;
        this.school = school;
    }

    public static Subject of(String name, int gradeType, School school) {
        return new Subject(name, gradeType, school);
    }


    protected Subject() {
    }
}
