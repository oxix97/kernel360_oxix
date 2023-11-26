package org.fastcampus.project.utils;

import lombok.Getter;

@Getter
public enum Define {
    KOREAN(1001),  //국어
    MATH(2001),    //수학
    DANCE(3001),   //방송댄스

    AB_TYPE(0),   // A, B, C
    SAB_TYPE(1),   // S, A, B, c
    PF_TYPE(2)   // P, F
    ;
    public final int code;

    Define(int code) {
        this.code = code;
    }
}
