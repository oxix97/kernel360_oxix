package org.fastcampus.project.score.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.project.base.db.AuditingField;
import org.fastcampus.project.subject.db.model.Subject;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@ToString
@Entity
@Slf4j
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Score extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Subject subject;

    private int value;

    private Score(Long id, Subject subject, int value) {
        this.id = id;
        this.subject = subject;
        this.value = value;
    }

    public static Score of(Long id, Subject subject, int value) {
        return new Score(id, subject, value);
    }


    protected Score() {

    }
}
