package org.fastcampus.project.subject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.score.db.repository.ScoreRepository;
import org.fastcampus.project.subject.converter.dto.SubjectDto;
import org.fastcampus.project.subject.db.model.Subject;
import org.fastcampus.project.subject.db.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Transactional(readOnly = true)
    public List<SubjectDto> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(SubjectDto::from)
                .toList();
    }

    public SubjectDto getSubject(Long majorId) {
        return SubjectDto.from(subjectRepository.getReferenceById(majorId));
    }
}
