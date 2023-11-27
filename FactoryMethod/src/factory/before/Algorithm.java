package factory.before;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {
    private static List<Node> nodes;
    private static int totalTime;
    private static int serviceTime;
    private static int waiting;

    public static void main(String[] args) {
        init();
        FIFO();
        SJF();
    }

    private static void SJF() {
        System.out.println("========SJF========");
        var q = new PriorityQueue<Node>((o1, o2) -> o1.serviceTime() - o2.serviceTime());
        q.addAll(nodes);
        scheduling(q);
    }

    private static void FIFO() {
        System.out.println("========FIFO========");
        var q = new PriorityQueue<Node>((o1, o2) -> o1.arrivalTime() - o2.arrivalTime());
        q.addAll(nodes);
        scheduling(q);
    }

    private static void scheduling(PriorityQueue<Node> q) {
        int totalWaitingTime = 0;
        while (!q.isEmpty()) {
            if (serviceTime == 0) {
                Node n = q.poll();
                int waitingTime = Math.max((totalTime - n.arrivalTime()), 0);
                System.out.println(n.name() +
                        ", 도착 시간 : " + n.arrivalTime() +
                        ", 소요 시간 : " + n.serviceTime() +
                        ", 서비스 시작 시간 : " + totalTime +
                        ", 기다린 시간 : " + waitingTime);
                totalWaitingTime += waitingTime;
                waiting = 0;
                if (n.arrivalTime() > totalTime) {
                    totalTime = n.arrivalTime();
                    serviceTime = n.serviceTime();
                } else {
                    serviceTime = n.serviceTime();
                }
            } else {
                waiting++;
            }
            totalTime++;
            serviceTime--;
        }
        System.out.println("총 기다린 시간 : " + totalWaitingTime);
        System.out.println("총 걸린 시간 : " + (totalTime + serviceTime));
        totalTime = 0;
        serviceTime = 0;
        waiting = 0;
    }

    public static void init() {
        nodes = new ArrayList<>();
        nodes.add(Node.of("이영주", 0, 1, 0));
        nodes.add(Node.of("장호윤", 5, 5, 0));
        nodes.add(Node.of("이종찬", 2, 12, 0));
        nodes.add(Node.of("문찬욱", 6, 6, 0));
        nodes.add(Node.of("손민우", 9, 1, 0));
        nodes.add(Node.of("송예진", 10, 3, 0));
        nodes.add(Node.of("김찬규", 7, 3, 0));
    }

}
