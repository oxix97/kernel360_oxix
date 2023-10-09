package org.example.model;

public enum Command {
    PHOTO("사진 파일명을 입력하세요 : "),
    NAME("이름을 입력하세요 : "),
    EMAIL("이메일을 입력하세요 : "),
    ADDRESS("주소를 입력하세요 : "),
    PHONE_NUMBER("전화번호를 입력하세요 : "),
    BIRTH("생년월일을 입력하세요 (예: 1900-01-01): "),
    EDUCATION("학력 정보를 입력하세요 (종료는 q)\n졸업년도 학교명 전공 졸업여부"),
    CAREER("경력 정보를 입력하세요(종료는 q):\n근무기간 근무처 담당업무 근속연수"),
    SELFINFO("자기소개서를 입력하세요. 여러 줄을 입력하려면 빈 줄을 입력하세요."),
    FINISH("이력서 생성이 완료되었습니다."),

    PERSONINFO_TITLE("사진,이름,이메일,주소,전화번호,생년월일"),
    CAREER_TITLE("근무기간,근무처,담당업무,근속연수"),
    EDUCATION_TITLE("졸업년도,학교명,전공,졸업여부"),

    CREATE_ERR("엑셀 파일 생성 중 문제 발생"),
    SAVE_ERR("엑셀 파일 저장 중 문제 발생"),
    ;
    private final String command;

    public String getCommand() {
        return command;
    }

    Command(String command) {
        this.command = command;
    }
}