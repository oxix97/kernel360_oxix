package org.fastcampus.project.student.converter.dto;

import org.fastcampus.project.school.converter.dto.SchoolDto;
import org.fastcampus.project.school.db.model.School;
import org.fastcampus.project.student.db.model.Student;

import java.time.LocalDateTime;

/**
 * DTO for {@link org.fastcampus.project.student.db.model.Student}
 */
public record StudentDto(
        Long id,
        String name,
        Long majorSubject,
        SchoolDto school,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static StudentDto of(
            Long id,
            String name,
            Long majorSubject,
            SchoolDto school,
            LocalDateTime createdAt,
            String createdBy,
            LocalDateTime modifiedAt,
            String modifiedBy
    ) {
        return new StudentDto(
                id,
                name,
                majorSubject,
                school,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

    public static StudentDto from(Student entity) {
        return new StudentDto(
                entity.getId(),
                entity.getName(),
                entity.getMajorSubject(),
                SchoolDto.from(entity.getSchool()),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Student toEntity(School school) {
        return Student.of(
                name,
                majorSubject,
                school
        );
    }
}