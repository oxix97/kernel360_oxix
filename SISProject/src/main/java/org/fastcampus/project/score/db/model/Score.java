package org.fastcampus.project.score.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.base.db.AuditingField;
import org.fastcampus.project.student.db.model.Student;
import org.fastcampus.project.subject.db.model.Subject;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@ToString
@Slf4j
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Score extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Subject subject;

    @ManyToOne(optional = false)
    private Student student;

    private int value;

    private Score(Subject subject, Student student, int value) {
        this.subject = subject;
        this.student = student;
        this.value = value;
    }

    public static Score of(
            Subject subject,
            Student student,
            int value
    ) {
        return new Score(subject, student, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score score)) return false;
        return Objects.equals(id, score.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    protected Score() {

    }
}
