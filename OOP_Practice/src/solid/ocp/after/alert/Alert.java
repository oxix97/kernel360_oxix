package solid.ocp.after.alert;


import solid.ocp.after.ApiStatusInfo;
import solid.ocp.after.notification.Notification;
import solid.ocp.after.notification.NotificationEmergencyLevel;

public class Alert extends AlertHandler {
    private final AlertRule rule;
    private final Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        super(rule, notification);
        this.rule = rule;
        this.notification = notification;
    }

    @Override
    public void check(ApiStatusInfo info) {
        long tps = info.getRequestCount() / info.getErrorCount();
        if (tps > rule.getMatchedRule(info.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (info.getErrorCount() > rule.getMatchedRule(info.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
