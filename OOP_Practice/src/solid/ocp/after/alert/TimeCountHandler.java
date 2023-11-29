package solid.ocp.after.alert;

import solid.ocp.after.ApiStatusInfo;
import solid.ocp.after.notification.Notification;

public class TimeCountHandler extends AlertHandler {

    public TimeCountHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatusInfo info) {

    }
}
