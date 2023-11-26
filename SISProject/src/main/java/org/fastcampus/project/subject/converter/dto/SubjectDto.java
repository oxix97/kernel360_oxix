package org.fastcampus.project.subject.converter.dto;

import org.fastcampus.project.school.converter.dto.SchoolDto;
import org.fastcampus.project.school.db.model.School;
import org.fastcampus.project.student.converter.dto.StudentSubjectDto;
import org.fastcampus.project.student.db.model.StudentSubject;
import org.fastcampus.project.subject.db.model.Subject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for {@link org.fastcampus.project.subject.db.model.Subject}
 */
public record SubjectDto(
        Long id,
        String name,
        int gradeType,
        SchoolDto school,
        List<StudentSubjectDto> students,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static SubjectDto of(
            Long id,
            String name,
            int gradeType,
            SchoolDto school,
            List<StudentSubjectDto> students,
            LocalDateTime createdAt,
            String createdBy,
            LocalDateTime modifiedAt,
            String modifiedBy
    ) {
        return new SubjectDto(id, name, gradeType,school, students, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static SubjectDto from(Subject entity) {
        return new SubjectDto(
                entity.getId(),
                entity.getName(),
                entity.getGradeType(),
                SchoolDto.from(entity.getSchool()),
                entity.getStudents().stream().map(StudentSubjectDto::from).toList(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Subject toEntity(School school) {
        return Subject.of(
                name,
                gradeType,
                school
        );
    }
}