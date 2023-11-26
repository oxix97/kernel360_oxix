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
import java.util.Objects;

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

    private School(String name) {
        this.name = name;
    }

    public static School of(String name) {
        return new School(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School school)) return false;
        return Objects.equals(id, school.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    protected School() {
    }
}