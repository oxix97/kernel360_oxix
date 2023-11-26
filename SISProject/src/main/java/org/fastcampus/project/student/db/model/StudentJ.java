package org.fastcampus.project.student.db.model;
import org.fastcampus.project.score.db.model.ScoreJ;
import org.fastcampus.project.subject.db.model.SubjectJ;

import java.util.ArrayList;

public class StudentJ{

    private int studentId;            //학번
    private String studentName;        //이름
    private SubjectJ majorSubjectJ;    //중점 과목

    //학생의 성적 리스트
    //addSubjectSocre() 메서드가 호출되면 리스트에 추가 됨
    private ArrayList<ScoreJ> ScoreJList = new ArrayList<ScoreJ>();

    public StudentJ(int studentId, String studentName, SubjectJ majorSubjectJ) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.majorSubjectJ = majorSubjectJ;
    }

    public void addSubjectScoreJ(ScoreJ ScoreJ) {
        ScoreJList.add(ScoreJ);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public SubjectJ getMajorSubjectJ() {
        return majorSubjectJ;
    }

    public void setMajorSubjectJ(SubjectJ majorSubjectJ) {
        this.majorSubjectJ = majorSubjectJ;
    }

    public ArrayList<ScoreJ> getScoreJList() {
        return ScoreJList;
    }

    public void setScoreJList(ArrayList<ScoreJ> ScoreJList) {
        this.ScoreJList = ScoreJList;
    }
}
