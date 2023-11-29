package after;

public class AICar extends Car {
    @Override
    public void drive() {
        System.out.println("AI drive");
    }

    @Override
    public void washCar() {
        System.out.println("AI wash");
    }
}
