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

    @ManyToOne(optional = false)
    private School school;

    @ToString.Exclude
    @OneToMany(mappedBy = "subject")
    private List<StudentSubject> students = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "subject")
    private List<Score> scores = new ArrayList<>();


    private Subject(Long id, String name, School school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public static Subject of(Long id, String name, School school) {
        return new Subject(id, name, school);
    }


    protected Subject() {
    }
}
