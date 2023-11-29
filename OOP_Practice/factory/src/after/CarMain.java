package after;

public class CarMain {

    public static void main(String[] args) {
        // 차주의 이름을 생성자의 매개변수로 받습니다.
        CarFactory factory = CarFactory.getFactory();

        CarInfo sonata = factory.createCar(OwnerInfo.of(CarName.SONATA.name(), "종찬"));
        CarInfo grandeur = factory.createCar(OwnerInfo.of(CarName.GRANDEUR.name(), "소현"));
        CarInfo genesis = factory.createCar(OwnerInfo.of(CarName.GENESIS.name(), "승규"));

        System.out.println(sonata);
        System.out.println(grandeur);
        System.out.println(genesis);
        System.out.println("===================");
        // 주인차를 찾아줍니다.
        System.out.println(factory.searchMyCar("종찬"));
        System.out.println(factory.searchMyCar("소현"));
        System.out.println(factory.searchMyCar("승규"));
        System.out.println("===================");

        Car car = new Car();
        Car aiCar = new AICar();
        car.startCar();
        aiCar.startCar();
        car.drive();
        aiCar.drive();
    }
}
