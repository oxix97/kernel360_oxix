package solid.ocp.after.alert;

import lombok.AllArgsConstructor;
import solid.ocp.after.ApiStatusInfo;
import solid.ocp.after.notification.Notification;

@AllArgsConstructor
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public abstract void check(ApiStatusInfo info);
}
