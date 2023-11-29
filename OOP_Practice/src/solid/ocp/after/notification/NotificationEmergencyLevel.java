package solid.ocp.after.notification;

import lombok.Getter;

@Getter
public enum NotificationEmergencyLevel {
    URGENCY(1001L),
    SEVERE(1002L);
    private final Long value;

    NotificationEmergencyLevel(Long value) {
        this.value = value;
    }
}