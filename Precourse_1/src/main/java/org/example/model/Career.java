package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Career {
    private String workPeriod;
    private String companyName;
    private String jobTitle;
    private String employmentYears;

    public static Career of(String workPeriod, String companyName, String jobTitle, String employmentYears) {
        return new Career(workPeriod, companyName, jobTitle, employmentYears);
    }

    public static Career of(String[] str) {
        return new Career(str[0], str[1], str[2], str[3]);
    }

    public Career(String workPeriod, String companyName, String jobTitle, String employmentYears) {
        this.workPeriod = workPeriod;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.employmentYears = employmentYears;
    }

    @Override
    public String toString() {
        return "Career{" +
                "workPeriod='" + workPeriod + '\'' +
                ", companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employmentYears='" + employmentYears + '\'' +
                '}';
    }
}
