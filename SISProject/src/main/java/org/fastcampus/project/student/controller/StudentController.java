package org.fastcampus.project.student.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.student.service.StudentService;
import org.fastcampus.project.subject.service.SubjectService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/student")
@RestController
public class StudentController {
    private final StudentService studentService;
    private final SubjectService subjectService;
    @GetMapping("/{studentId}")
    public String getStudentMajorName(
            @PathVariable Long studentId
    ) {
        Long majorId = studentService.getStudent(studentId).majorSubject();
        return subjectService.getSubject(majorId).name();
    }
}
