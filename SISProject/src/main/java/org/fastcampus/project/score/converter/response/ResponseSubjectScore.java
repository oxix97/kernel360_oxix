package org.fastcampus.project.score.converter.response;

import org.fastcampus.project.report.GenerateGradeReport;
import org.fastcampus.project.score.converter.dto.ScoreDto;

public record ResponseSubjectScore(
        String studentName,
        Long studentId,
        String majorSubject,
        int value,
        String grade
) {
    public static ResponseSubjectScore of(
            ScoreDto score
    ) {
        return new ResponseSubjectScore(
                score.student().name(),
                score.student().id(),
                majorSubjectName(score.student().majorSubject()),
                score.value(),
                GenerateGradeReport.evaluateGradeByScoreAndStrategy(score)
        );
    }

    private static String majorSubjectName(int majorSubject) {
        return switch (majorSubject) {
            case 1001 -> "국어";
            case 2001 -> "영어";
            case 3001 -> "수학";
            default -> "nope";
        };
    }
}
