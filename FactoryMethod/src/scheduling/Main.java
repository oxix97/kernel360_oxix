package scheduling;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Algorithm fifo = new FIFO();
        fifo.addAll(data());
        fifo.run();
        Algorithm sjf = new SJF();
        sjf.addAll(data());
        sjf.run();
    }

    public static List<Node> data() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(Node.of("이영주", 0, 1, 0));
        nodes.add(Node.of("장호윤", 5, 5, 0));
        nodes.add(Node.of("이종찬", 2, 12, 0));
        nodes.add(Node.of("문찬욱", 6, 6, 0));
        nodes.add(Node.of("손민우", 9, 1, 0));
        nodes.add(Node.of("송예진", 10, 3, 0));
        nodes.add(Node.of("김찬규", 7, 3, 0));
        return nodes;
    }
}
