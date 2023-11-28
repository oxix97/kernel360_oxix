package org.fastcampus.project.score.converter.request;

public record RequestScore(
        Long studentId,
        Long subjectId,
        int value
) {

}
