package org.fastcampus.project.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.subject.converter.dto.SubjectDto;
import org.fastcampus.project.subject.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/subject")
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/all")
    public List<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

}

