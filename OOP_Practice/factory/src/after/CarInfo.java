package after;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CarInfo {
    private Long code;
    private String owner;

    private CarInfo(Long code, String owner) {
        this.code = code;
        this.owner = owner;
    }

    public static CarInfo of(Long code, String owner) {
        return new CarInfo(code, owner);
    }
}
