package org.fastcampus.project.subject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.score.db.repository.ScoreRepository;
import org.fastcampus.project.subject.converter.dto.SubjectDto;
import org.fastcampus.project.subject.db.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectDto getSubject(Long id) {
        return SubjectDto.from(subjectRepository.findById(id).orElseThrow());
    }
}
