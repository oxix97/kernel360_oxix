package solid.ocp.before;


public class Alert {
    private AlertRule rule;
    private Notification notification;
    private Object NotificationEmergencyLevel;

    public Alert(AlertRule rule, Notification notification){
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount, long errorCount, long duration){
        long tps = requestCount/errorCount;
        if(tps > rule.getMatchedRule(api).getMaxTps()){
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if(errorCount > rule.getMatchedRule(api).getMaxErrorCount()){
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
