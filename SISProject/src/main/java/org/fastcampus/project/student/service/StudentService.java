package org.fastcampus.project.student.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.student.converter.dto.StudentDto;
import org.fastcampus.project.student.db.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public StudentDto getStudent(Long studentId) {
        return StudentDto.from(studentRepository.getReferenceById(studentId));
    }
}
