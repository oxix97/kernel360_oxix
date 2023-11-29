package after;


import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static CarFactory factory;
    private final List<CarInfo> carInfos = new ArrayList<>();

    private CarFactory() {
    }

    public static CarFactory getFactory() {
        if (factory == null) {
            factory = new CarFactory();
        }
        return factory;
    }

    public CarInfo searchMyCar(String owner) {
        return carInfos.stream()
                .filter(it -> it.getOwner().equals(owner))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("차량 조회 불가"));
    }

    public CarInfo createCar(OwnerInfo info) {
        CarInfo carInfo = CarInfo.of(CarName.valueOf(info.getCarName()).getCode(), info.getOwner());
        carInfos.add(carInfo);
        return carInfo;
    }
}
