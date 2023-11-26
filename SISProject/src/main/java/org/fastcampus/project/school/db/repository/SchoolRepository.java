package org.fastcampus.project.school.db.repository;

import org.fastcampus.project.school.db.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
