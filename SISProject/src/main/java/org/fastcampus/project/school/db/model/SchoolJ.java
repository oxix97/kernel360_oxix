package org.fastcampus.project.school.db.model;


import org.fastcampus.project.student.db.model.StudentJ;
import org.fastcampus.project.subject.db.model.SubjectJ;

import java.util.ArrayList;

public class SchoolJ {

    private static SchoolJ instance = new SchoolJ();

    private static String SCHOOL_NAME = "SilverBell SchoolJ";
    private ArrayList<StudentJ> studentJList = new ArrayList<StudentJ>();
    private ArrayList<SubjectJ> subjectJList = new ArrayList<SubjectJ>();

    private SchoolJ() {
    }

    public static SchoolJ getInstance() {
        if (instance == null)
            instance = new SchoolJ();
        return instance;
    }

    public ArrayList<StudentJ> getStudentList() {
        return studentJList;
    }

    public void addStudent(StudentJ studentJ) {
        studentJList.add(studentJ);
    }

    public void addSubject(SubjectJ subjectJ) {
        subjectJList.add(subjectJ);
    }

    public ArrayList<SubjectJ> getSubjectList() {
        return subjectJList;
    }

    public void setSubjectList(ArrayList<SubjectJ> subjectJList) {
        this.subjectJList = subjectJList;
    }
}

