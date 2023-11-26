package org.fastcampus.project.student.db.repository;

import org.fastcampus.project.student.db.model.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {

}
