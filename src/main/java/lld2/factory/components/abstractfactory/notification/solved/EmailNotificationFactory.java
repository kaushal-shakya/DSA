package lld2.factory.components.abstractfactory.notification.solved;

import lld2.factory.components.abstractfactory.notification.solved.notification.EmailNotification;
import lld2.factory.components.abstractfactory.notification.solved.notification.Notification;
import lld2.factory.components.abstractfactory.notification.solved.sender.EmailNotificationSender;
import lld2.factory.components.abstractfactory.notification.solved.sender.NotificationSender;
import lld2.factory.components.abstractfactory.notification.solved.template.NotificationTemplate;
import lld2.factory.components.abstractfactory.notification.solved.template.EmailNotificationTemplate;

public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }

    @Override
    public Notification createNofification(String recipient, String sender, NotificationTemplate template) {
        return new EmailNotification(recipient, sender, template);
    }

    @Override
    public NotificationSender createSender(Notification notification) {
        return new EmailNotificationSender(notification);
    }

    @Override
    public NotificationTemplate createTemplate(String message) {
        return new EmailNotificationTemplate(message);
    }
}