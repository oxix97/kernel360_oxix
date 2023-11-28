package observer;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {

        Observer consoleObserver = new ConsoleObserver();
        Observer fileObserver = new FileObserver();
        Subject subject = new ConcreteSubject();
        Message message = new Message();
        subject.registerObserver(consoleObserver);
        subject.registerObserver(fileObserver);
        for(int i = 0; i<10; i++) {
            subject.notifyObservers(message.getMessage());
        }

    }
}
