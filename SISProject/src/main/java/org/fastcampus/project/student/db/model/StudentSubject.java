package org.fastcampus.project.student.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.fastcampus.project.subject.db.model.Subject;

@ToString
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
}
