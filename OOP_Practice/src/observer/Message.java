package observer;

public class Message {
    private String message;
    public static int index = 0;
    public String getMessage(){

        String[] greetings = {"안녕하세요", "반갑습니다", "좋은 아침입니다", "오늘도 즐거운 하루 되세요"};

        if(index == 4) index = 0;
        return greetings[index++];

    }
}
