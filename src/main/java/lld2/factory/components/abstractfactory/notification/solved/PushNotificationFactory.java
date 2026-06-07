package lld2.factory.components.abstractfactory.notification.solved;

import lld2.factory.components.abstractfactory.notification.solved.notification.Notification;
import lld2.factory.components.abstractfactory.notification.solved.notification.PushNotification;
import lld2.factory.components.abstractfactory.notification.solved.sender.NotificationSender;
import lld2.factory.components.abstractfactory.notification.solved.sender.PushNotificationSender;
import lld2.factory.components.abstractfactory.notification.solved.template.NotificationTemplate;
import lld2.factory.components.abstractfactory.notification.solved.template.PushNotificationTemplate;

public class PushNotificationFactory extends NotificationFactory {

    @Override
    public NotificationType notificationType() {
        return  NotificationType.PUSH;
    }

    @Override
    public Notification createNofification(String recipient, String sender, NotificationTemplate template) {
        return new PushNotification(recipient, template);
    }

    @Override
    public NotificationSender createSender(Notification notification) {

        return new PushNotificationSender(notification);
    }

    @Override
    public NotificationTemplate createTemplate(String message) {
        return new PushNotificationTemplate(message);
    }
}