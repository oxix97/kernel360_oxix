package org.fastcampus.project.score.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.score.converter.dto.ScoreDto;
import org.fastcampus.project.score.converter.request.RequestScore;
import org.fastcampus.project.score.converter.response.ResponseStudentScore;
import org.fastcampus.project.score.converter.response.ResponseSubjectScore;
import org.fastcampus.project.score.service.ScoreService;
import org.fastcampus.project.student.converter.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/score")
@RestController
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/subject/{subjectId}")
    public List<ResponseSubjectScore> getScoresBySubjectId(
            @PathVariable Long subjectId
    ) {
        return scoreService.getScoresBySubjectId(subjectId).stream()
                .map(ResponseSubjectScore::of)
                .toList();
    }

    @GetMapping("/student/{studentId}")
    public List<ResponseStudentScore> getScoreByStudentId(
            @PathVariable Long studentId
    ) {
        return scoreService.getStudentBySubjectAllScores(studentId).stream()
                .map(it -> new ResponseStudentScore(it.subject().name(), it.value()))
                .toList();
    }

    @PostMapping("/add")
    public void addScore(
            @RequestBody RequestScore request
    ) {
        log.info("request: {}", request);
        scoreService.addScore(request);
    }

}
