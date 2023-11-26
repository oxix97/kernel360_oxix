package org.fastcampus.project.test;


import org.fastcampus.project.report.GenerateGradeReport;
import org.fastcampus.project.school.db.model.SchoolJ;
import org.fastcampus.project.score.db.model.ScoreJ;
import org.fastcampus.project.student.db.model.StudentJ;
import org.fastcampus.project.subject.db.model.SubjectJ;
import org.fastcampus.project.utils.Define;

public class TestMain {

	SchoolJ goodSchoolJ = SchoolJ.getInstance();
	SubjectJ korean;
	SubjectJ math;
	SubjectJ dance;

	GenerateGradeReport gradeReport = new GenerateGradeReport();

	public static void main(String[] args) {

		TestMain test = new TestMain();

		test.creatSubject();
		test.createStudent();

		String report = test.gradeReport.getReport(); //성적 결과 생성
		System.out.println(report); // 출력

	}

	//테스트 과목 생성
	public void creatSubject(){

		korean = new SubjectJ("국어", Define.KOREAN);
		math = new SubjectJ("수학", Define.MATH);
		dance = new SubjectJ("방송댄스", Define.DANCE);

		dance.setGradeType(Define.PF_TYPE);

		goodSchoolJ.addSubject(korean);
		goodSchoolJ.addSubject(math);
		goodSchoolJ.addSubject(dance);
	}

	//테스트 학생 생성
	public void createStudent(){

		StudentJ studentJ1 = new StudentJ(211213, "강감찬", korean  );
		StudentJ studentJ2 = new StudentJ(212330, "김유신", math  );
		StudentJ studentJ3 = new StudentJ(201518, "신사임당", korean  );
		StudentJ studentJ4 = new StudentJ(202360, "이순신", korean  );
		StudentJ studentJ5 = new StudentJ(201290, "홍길동", math );

		goodSchoolJ.addStudent(studentJ1);
		goodSchoolJ.addStudent(studentJ2);
		goodSchoolJ.addStudent(studentJ3);
		goodSchoolJ.addStudent(studentJ4);
		goodSchoolJ.addStudent(studentJ5);

		korean.register(studentJ1);
		korean.register(studentJ2);
		korean.register(studentJ3);
		korean.register(studentJ4);
		korean.register(studentJ5);

		math.register(studentJ1);
		math.register(studentJ2);
		math.register(studentJ3);
		math.register(studentJ4);
		math.register(studentJ5);


		dance.register(studentJ1);
		dance.register(studentJ2);
		dance.register(studentJ3);

		addScoreForStudent(studentJ1, korean, 95);
		addScoreForStudent(studentJ1, math, 56);

		addScoreForStudent(studentJ2, korean, 95);
		addScoreForStudent(studentJ2, math, 95);

		addScoreForStudent(studentJ3, korean, 100);
		addScoreForStudent(studentJ3, math, 88);

		addScoreForStudent(studentJ4, korean, 89);
		addScoreForStudent(studentJ4, math, 95);

		addScoreForStudent(studentJ5, korean, 85);
		addScoreForStudent(studentJ5, math, 56);

		addScoreForStudent(studentJ1, dance, 95);
		addScoreForStudent(studentJ2, dance, 85);
		addScoreForStudent(studentJ3, dance, 55);
	}

	//과목별 성적 입력
	public void addScoreForStudent(StudentJ studentJ, SubjectJ subjectJ, int point){

		ScoreJ score = new ScoreJ(studentJ.getStudentId(), subjectJ, point);
		studentJ.addSubjectScoreJ(score);

	}
}
