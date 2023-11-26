package org.fastcampus.project.score.db.repository;

import org.fastcampus.project.score.db.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllBySubjectId(Long subjectId);
    List<Score> findAllByStudentId(Long studentId);
}
