package after;

import lombok.Getter;

@Getter
public enum CarName {
    SONATA(101L),
    GRANDEUR(201L),
    GENESIS(301L);

    CarName(Long code) {
        this.code = code;
    }

    private final Long code;
}
