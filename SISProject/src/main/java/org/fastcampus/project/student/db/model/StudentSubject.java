package org.fastcampus.project.student.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.subject.db.model.Subject;

import java.util.Objects;

@ToString
@Slf4j
@Getter
@Entity
public class StudentSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private StudentSubject(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
    }

    public static StudentSubject of(Student student, Subject subject) {
        return new StudentSubject(student, subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentSubject that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    protected StudentSubject() {
    }
}
