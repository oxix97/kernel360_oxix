package solid.ocp.after;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiStatusInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long duration;
    private long timeCount;
}
