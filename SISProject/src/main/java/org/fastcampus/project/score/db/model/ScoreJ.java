package org.fastcampus.project.score.db.model;

import org.fastcampus.project.subject.db.model.SubjectJ;

public class ScoreJ {
	int studentId;   //학번
	SubjectJ subjectJ; //과목
	int point;      //점수
	
	public ScoreJ(int studentId, SubjectJ subjectJ, int point){
		this.studentId = studentId;
		this.subjectJ = subjectJ;
		this.point = point;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public SubjectJ getSubject() {
		return subjectJ;
	}

	public void setSubject(SubjectJ subjectJ) {
		this.subjectJ = subjectJ;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String toString(){
		return "학번:" + studentId + "," + subjectJ.getSubjectName() + ":" + point;
	}
}
