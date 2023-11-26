package org.fastcampus.project.subject.db.repository;

import org.fastcampus.project.subject.db.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT s FROM Subject s JOIN s.students ss WHERE ss.student.id = :studentId")
    List<Subject> findSubjectsByStudentId(@Param("studentId") Long studentId);
}
