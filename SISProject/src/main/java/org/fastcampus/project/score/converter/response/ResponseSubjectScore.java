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

    private static String majorSubjectName(Long majorSubject) {
        return switch (majorSubject.intValue()) {
            case 1001 -> "국어";
            case 2001 -> "수학";
            case 3001 -> "댄스";
            default -> "nope";
        };
    }
}
