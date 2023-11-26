package org.fastcampus.project.student.db.repository;

import org.fastcampus.project.student.db.model.Student;
import org.fastcampus.project.student.db.model.StudentSubject;
import org.fastcampus.project.subject.db.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
