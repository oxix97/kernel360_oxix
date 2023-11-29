package solid.ocp.after.alert;

import lombok.AllArgsConstructor;
import solid.ocp.after.ApiStatusInfo;
import solid.ocp.after.notification.Notification;
import solid.ocp.after.notification.NotificationEmergencyLevel;

public class ErrorCountHandler extends AlertHandler {
    private final AlertRule rule;
    private final Notification notification;

    public ErrorCountHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
        this.rule = rule;
        this.notification = notification;
    }

    @Override
    public void check(ApiStatusInfo info) {
        if (info.getErrorCount() > rule.getMatchedRule(info.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
