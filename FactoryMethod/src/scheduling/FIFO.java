package scheduling;

import java.util.PriorityQueue;

public class FIFO extends Algorithm {
    public FIFO() {
        super(new PriorityQueue<>((o1, o2) -> o1.arrivalTime() - o2.arrivalTime()));
    }
}
