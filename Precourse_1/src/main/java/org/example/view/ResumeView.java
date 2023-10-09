package org.example.view;

import org.example.model.Career;
import org.example.model.Education;
import org.example.model.PersonInfo;
import org.example.model.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeView {
    static Scanner sc = new Scanner(System.in);
    static final String QUIT = "q";
    static final String BLANK = " ";

    public PersonInfo inputPersonInfo() {
        int idx = 0;
        String[] inputs = new String[6];
        for (Command cmd : Command.values()) {
            System.out.print(cmd.getCommand());
            inputs[idx] = sc.nextLine();
            if (++idx == inputs.length) break;
        }
        System.out.println();
        return PersonInfo.of(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputs[5]);
    }

    public List<Education> inputEducationList() {
        List<Education> educations = new ArrayList<>();
        while (true) {
            System.out.println(Command.EDUCATION.getCommand());
            String input = sc.nextLine();
            if (input.equals(QUIT)) break;
            educations.add(Education.of(input.split(BLANK)));
        }
        return educations;
    }

    public List<Career> inputCareerList() {
        List<Career> careers = new ArrayList<>();
        while (true) {
            System.out.println(Command.CAREER.getCommand());
            String input = sc.nextLine();
            if (input.equals(QUIT)) break;
            careers.add(Career.of(input.split(BLANK)));
        }
        return careers;
    }

    public String inputSelfInformation() {
        StringBuilder sb = new StringBuilder();
        System.out.println(Command.SELFINFO.getCommand());
        while (true) {
            String input = sc.nextLine();
            if (input.trim().isEmpty()) break;
            sb.append(input).append('\n');
        }
        return sb.toString();
    }
}
