package org.fastcampus.project.report;


import org.fastcampus.project.grade.BasicEvaluation;
import org.fastcampus.project.grade.GradeEvaluation;
import org.fastcampus.project.grade.MajorEvaluation;
import org.fastcampus.project.grade.PassFailEvaluation;
import org.fastcampus.project.school.db.model.SchoolJ;
import org.fastcampus.project.score.db.model.Score;
import org.fastcampus.project.score.db.model.ScoreJ;
import org.fastcampus.project.student.db.model.StudentJ;
import org.fastcampus.project.subject.db.model.SubjectJ;
import org.fastcampus.project.utils.Define;

import java.util.ArrayList;

public class GenerateGradeReport {

	SchoolJ schoolJ = SchoolJ.getInstance();
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름  |  학번  |중점과목| 점수   \n";
	public static final String LINE = "-------------------------------------\n";
	private StringBuilder buffer = new StringBuilder();

	public String getReport(){
		ArrayList<SubjectJ> subjectJList = schoolJ.getSubjectList();  // 모든 과목에 대한 학점 산출
		for( SubjectJ subjectJ : subjectJList) {
			makeHeader(subjectJ);
			makeBody(subjectJ);
			makeFooter();
		}
		return buffer.toString();  // String 으로 반환
	}

	public void makeHeader(SubjectJ subjectJ){
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subjectJ.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE );
		buffer.append(GenerateGradeReport.HEADER );
		buffer.append(GenerateGradeReport.LINE);
	}

	public void makeBody(SubjectJ subjectJ){

		ArrayList<StudentJ> studentJList = subjectJ.getStudentList();  // 각 과목의 학생들

		for(int i = 0; i< studentJList.size(); i++){
			StudentJ studentJ = studentJList.get(i);
			buffer.append(studentJ.getStudentName());
			buffer.append(" | ");
			buffer.append(studentJ.getStudentId());
			buffer.append(" | ");
			buffer.append(studentJ.getMajorSubjectJ().getSubjectName() + "\t");
			buffer.append(" | ");

			getScoreGrade(studentJ, subjectJ);  //학생별 해당과목 학점 계산
			buffer.append("\n");
			buffer.append(LINE);
		}
	}

	public void getScoreGrade(StudentJ studentJ, SubjectJ subjectJ){

		ArrayList<ScoreJ> scoreList = studentJ.getScoreJList();
		int majorId = studentJ.getMajorSubjectJ().getSubjectId();


		for(int i=0; i<scoreList.size(); i++){  // 학생이 가진 점수들

			ScoreJ score = scoreList.get(i);
			if(score.getSubject().getSubjectId() == subjectJ.getSubjectId()) {  // 현재 학점을 산출할 과목

				evaluateGradeByScoreAndStrategy(subjectJ, score, majorId);

			}
		}
	}

	public void evaluateGradeByScoreAndStrategy(SubjectJ subjectJ, ScoreJ score, int majorId) {

		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation(), new PassFailEvaluation()};
		String grade;

		if( subjectJ.getGradeType() == Define.PF_TYPE) {
			grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
		}
		else {
			if(score.getSubject().getSubjectId() == majorId)  // 중점 과목인 경우
				grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());  //중점 과목 학점 평가 방법
			else
				grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint()); // 중점 과목이 아닌 경우
		}

		buffer.append(score.getPoint());
		buffer.append(":");
		buffer.append(grade);
		buffer.append(" | ");

	}

	public void makeFooter(){
		buffer.append("\n");
	}
}