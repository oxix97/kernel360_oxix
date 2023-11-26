package org.fastcampus.project.school.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.base.db.AuditingField;
import org.fastcampus.project.student.db.model.Student;
import org.fastcampus.project.subject.db.model.Subject;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class School extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ToString.Exclude
    @Setter
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    @ToString.Exclude
    @Setter
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    private School(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static School of(Long id, String name) {
        return new School(id, name);
    }

    protected School() {
    }
}