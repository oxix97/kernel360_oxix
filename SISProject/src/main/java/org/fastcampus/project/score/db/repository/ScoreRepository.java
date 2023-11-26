package org.fastcampus.project.score.db.repository;

import org.fastcampus.project.score.db.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
