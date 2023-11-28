package scheduling;

import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {
    private PriorityQueue<Node> q;

    public Algorithm(PriorityQueue<Node> q) {
        this.q = q;
    }

    public void addAll(List<Node> nodes) {
        q.addAll(nodes);
    }

    public void run() {
        int totalWaitingTime = 0;
        int serviceTime = 0;
        int totalTime = 0;

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
                if (n.arrivalTime() > totalTime) {
                    totalTime = n.arrivalTime();
                    serviceTime = n.serviceTime();
                } else {
                    serviceTime = n.serviceTime();
                }
            }
            totalTime++;
            serviceTime--;
        }
        System.out.println("총 기다린 시간 : " + totalWaitingTime);
        System.out.println("걸린 시간 : " + (totalTime + serviceTime));
    }
}
