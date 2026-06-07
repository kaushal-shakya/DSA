package lld2.factory.components.abstractfactory.notification.solved;

import lld2.factory.components.abstractfactory.notification.solved.notification.Notification;
import lld2.factory.components.abstractfactory.notification.solved.sender.NotificationSender;
import lld2.factory.components.abstractfactory.notification.solved.template.NotificationTemplate;

public abstract class NotificationFactory {

    public abstract NotificationType notificationType();

    public abstract Notification createNofification(String recipient, String sender, NotificationTemplate template);

    public abstract NotificationSender createSender(Notification notification);

    public abstract NotificationTemplate createTemplate(String message);

}