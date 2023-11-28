package scheduling;

import java.util.PriorityQueue;

public class SJF extends Algorithm {
    public SJF() {
        super(new PriorityQueue<>((o1, o2) -> o1.serviceTime() - o2.serviceTime()));
    }
}
