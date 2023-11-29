package after;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OwnerInfo {
    private String carName;
    private String owner;

    private OwnerInfo(String carName, String owner) {
        this.carName = carName;
        this.owner = owner;
    }


    public static OwnerInfo of(String name, String owner) {
        return new OwnerInfo(name, owner);
    }
}
