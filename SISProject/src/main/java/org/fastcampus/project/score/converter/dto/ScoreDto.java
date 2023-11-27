package org.fastcampus.project.score.converter.dto;

import org.fastcampus.project.score.db.model.Score;
import org.fastcampus.project.student.converter.dto.StudentDto;
import org.fastcampus.project.student.db.model.Student;
import org.fastcampus.project.subject.converter.dto.SubjectDto;
import org.fastcampus.project.subject.db.model.Subject;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.fastcampus.project.score.db.model.Score}
 */
public record ScoreDto(
        Long id,
        SubjectDto subject,
        StudentDto student,
        int value,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ScoreDto of(
            SubjectDto subject,
            StudentDto student,
            int value
    ) {
        return new ScoreDto(
                null,
                subject,
                student,
                value,
                null,
                null,
                null,
                null
        );
    }
    public static ScoreDto of(
            Long id,
            SubjectDto subject,
            StudentDto student,
            int value,
            LocalDateTime createdAt,
            String createdBy,
            LocalDateTime modifiedAt,
            String modifiedBy
    ) {
        return new ScoreDto(
                id,
                subject,
                student,
                value,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

    public static ScoreDto from(Score entity) {
        return new ScoreDto(
                entity.getId(),
                SubjectDto.from(entity.getSubject()),
                StudentDto.from(entity.getStudent()),
                entity.getValue(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Score toEntity(Subject subject, Student student) {
        return Score.of(
                subject,
                student,
                value
        );
    }
}