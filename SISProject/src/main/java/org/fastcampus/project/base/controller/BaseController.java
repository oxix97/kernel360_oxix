package org.fastcampus.project.base.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.student.service.StudentService;
import org.fastcampus.project.subject.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BaseController {
    private final StudentService studentService;
    private final SubjectService subjectService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
