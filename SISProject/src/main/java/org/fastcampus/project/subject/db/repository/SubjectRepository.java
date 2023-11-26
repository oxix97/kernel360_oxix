package org.fastcampus.project.subject.db.repository;

import org.fastcampus.project.subject.db.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
