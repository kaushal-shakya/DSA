package lld2.factory.components.abstractfactory.notification.unsolvedtemplate.sender;

import lld2.factory.components.abstractfactory.notification.unsolvedtemplate.NotificationType;
import lld2.factory.components.abstractfactory.notification.unsolvedtemplate.notification.Notification;

public abstract class NotificationSender {
    private final Notification notification;

    public NotificationSender(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public abstract void send();

    public abstract NotificationType notificationType();

}