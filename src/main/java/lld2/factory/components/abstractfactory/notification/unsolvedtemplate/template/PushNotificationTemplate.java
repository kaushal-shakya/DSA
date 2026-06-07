package lld2.factory.components.abstractfactory.notification.unsolvedtemplate.template;

import lld2.factory.components.abstractfactory.notification.unsolvedtemplate.NotificationType;

public class PushNotificationTemplate extends NotificationTemplate{

    public PushNotificationTemplate(String message) {
        super(message);
    }

    @Override
    public String applyTemplate() {
        System.out.println("Applying Push notification template");
        return getMessage();
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}