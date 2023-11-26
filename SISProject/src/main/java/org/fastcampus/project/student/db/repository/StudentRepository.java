package org.fastcampus.project.student.db.repository;

import org.fastcampus.project.student.db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
