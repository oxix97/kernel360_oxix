package org.fastcampus.project.school.converter.dto;

import org.fastcampus.project.school.db.model.School;

import java.time.LocalDateTime;

/**
 * DTO for {@link org.fastcampus.project.school.db.model.School}
 */
public record SchoolDto(
        Long id,
        String name,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static SchoolDto of(
            Long id,
            String name,
            LocalDateTime createdAt,
            String createdBy,
            LocalDateTime modifiedAt,
            String modifiedBy
    ) {
        return new SchoolDto(id, name, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static SchoolDto from(School entity) {
        return SchoolDto.of(
                entity.getId(),
                entity.getName(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }
}