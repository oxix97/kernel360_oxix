package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Education {
    private String graduationYear;
    private String schoolName;
    private String major;
    private String graduationStatus;

    private Education(
            String graduationYear,
            String schoolName,
            String major,
            String graduationStatus
    ) {
        this.graduationYear = graduationYear;
        this.schoolName = schoolName;
        this.major = major;
        this.graduationStatus = graduationStatus;
    }

    public static Education of(String[] strs) {
        return new Education(
                strs[0],
                strs[1],
                strs[2],
                strs[3]
        );
    }

    public static Education of(
            String graduationYear,
            String schoolName,
            String major,
            String graduationStatus
    ) {
        return new Education(
                graduationYear,
                schoolName,
                major,
                graduationStatus
        );
    }

    @Override
    public String toString() {
        return "Education{" +
                "graduationYear='" + graduationYear + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", major='" + major + '\'' +
                ", graduationStatus='" + graduationStatus + '\'' +
                '}';
    }
}
