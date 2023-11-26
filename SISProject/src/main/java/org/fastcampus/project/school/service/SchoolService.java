package org.fastcampus.project.school.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.school.converter.dto.SchoolDto;
import org.fastcampus.project.school.db.repository.SchoolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolDto getSchool(Long id) {
        return SchoolDto.from(schoolRepository.getReferenceById(id));
    }
}
