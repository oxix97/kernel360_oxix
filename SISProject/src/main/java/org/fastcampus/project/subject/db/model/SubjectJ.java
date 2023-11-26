package org.fastcampus.project.subject.db.model;

import org.fastcampus.project.student.db.model.StudentJ;
import org.fastcampus.project.utils.Define;

import java.util.ArrayList;


public class SubjectJ {
	private String subjectName;  //과목 이름
	private int subjectId;      // 과목 고유번호
	private int gradeType;      // 과목 평가 방법 기본은 A,B 방식
	
	//수강 신청한 학생 리스트
	//register() 메서드를 호출하면 리스트에 추가 됨
	private ArrayList<StudentJ> studentJList = new ArrayList<StudentJ>();
	
	public SubjectJ(String subjectName, int subjectId){
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.gradeType = Define.AB_TYPE;   //기본적으로 A, B 타입
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public ArrayList<StudentJ> getStudentList() {
		return studentJList;
	}

	public void setStudentList(ArrayList<StudentJ> studentJList) {
		this.studentJList = studentJList;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public void register(StudentJ studentJ){  //수강신청
		studentJList.add(studentJ);
	}
}
