package lld2.factory.components.abstractfactory.notification.solved.sender;

import lld2.factory.components.abstractfactory.notification.solved.NotificationType;
import lld2.factory.components.abstractfactory.notification.solved.notification.Notification;

public class PushNotificationSender extends NotificationSender {

    public PushNotificationSender(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Sending Push notification to " + getNotification().getRecipient());
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}