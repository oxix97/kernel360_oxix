package solid.ocp.after.alert;

import solid.ocp.after.ApiStatusInfo;
import solid.ocp.after.notification.Notification;
import solid.ocp.after.notification.NotificationEmergencyLevel;

public class TpsHandler extends AlertHandler {
    public TpsHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatusInfo info) {
        long tps = info.getRequestCount() / info.getErrorCount();
        if (tps > rule.getMatchedRule(info.getApi()).getMaxTps()) {
            rule.notify(NotificationEmergencyLevel.URGENCY, "....")
        }
    }
}
