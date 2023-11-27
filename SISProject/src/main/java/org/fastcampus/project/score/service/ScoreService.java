package org.fastcampus.project.score.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.score.converter.dto.ScoreDto;
import org.fastcampus.project.score.converter.request.RequestScore;
import org.fastcampus.project.score.db.model.Score;
import org.fastcampus.project.score.db.repository.ScoreRepository;
import org.fastcampus.project.student.converter.dto.StudentDto;
import org.fastcampus.project.student.db.model.Student;
import org.fastcampus.project.student.db.repository.StudentRepository;
import org.fastcampus.project.subject.converter.dto.SubjectDto;
import org.fastcampus.project.subject.db.model.Subject;
import org.fastcampus.project.subject.db.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public List<ScoreDto> getAllSubjectScore() {
        return scoreRepository.findAll().stream()
                .map(ScoreDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ScoreDto> getStudentBySubjectAllScores(Long studentId) {
        return scoreRepository.findAllByStudentId(studentId).stream()
                .map(ScoreDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ScoreDto> getScoresBySubjectId(Long subjectId) {
        return scoreRepository.findAllBySubjectId(subjectId).stream()
                .map(ScoreDto::from)
                .toList();
    }

    public void addScore(RequestScore request) {
        Student student = studentRepository.getReferenceById(request.studentId());
        Subject subject = subjectRepository.getReferenceById(request.subjectId());
        Score score = Score.of(subject, student, request.value());
        log.info("score add student : {}",student);
        log.info("score add subject : {}", subject);
        log.info("score add score : {}", score);
        scoreRepository.save(score);
    }
}
