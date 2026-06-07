package lld2.factory.components.abstractfactory.notification.unsolvedtemplate.template;

import lld2.factory.components.abstractfactory.notification.unsolvedtemplate.NotificationType;

public abstract class NotificationTemplate {
    private String message;
    
    public NotificationTemplate(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public abstract String applyTemplate();
    public abstract NotificationType notificationType();

}