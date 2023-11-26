package org.fastcampus.project.score.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.score.converter.dto.ScoreDto;
import org.fastcampus.project.score.converter.response.ResponseStudentScore;
import org.fastcampus.project.score.converter.response.ResponseSubjectScore;
import org.fastcampus.project.score.service.ScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
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

}
