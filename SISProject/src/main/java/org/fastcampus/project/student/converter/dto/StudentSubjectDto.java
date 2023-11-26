package org.fastcampus.project.student.converter.dto;

import org.fastcampus.project.student.db.model.Student;
import org.fastcampus.project.student.db.model.StudentSubject;
import org.fastcampus.project.subject.converter.dto.SubjectDto;
import org.fastcampus.project.subject.db.model.Subject;

import java.io.Serializable;

/**
 * DTO for {@link org.fastcampus.project.student.db.model.StudentSubject}
 */
public record StudentSubjectDto(
        Long id,
        StudentDto student,
        SubjectDto subject
) {
    public static StudentSubjectDto of(Long id, StudentDto student, SubjectDto subject) {
        return new StudentSubjectDto(id, student, subject);
    }

    public static StudentSubjectDto from(StudentSubject entity) {
        return new StudentSubjectDto(
                entity.getId(),
                StudentDto.from(entity.getStudent()),
                SubjectDto.from(entity.getSubject())
        );
    }

    public StudentSubject toEntity(Student student, Subject subject) {
        return StudentSubject.of(student, subject);
    }
}