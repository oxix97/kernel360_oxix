package factory.before;

public record Node(
        String name,
        int arrivalTime,
        int serviceTime,
        int waitingTime
) {
    public static Node of(String name, int arrivalTime, int serviceTime, int waitingTime) {
        return new Node(name, arrivalTime, serviceTime, waitingTime);
    }
}
