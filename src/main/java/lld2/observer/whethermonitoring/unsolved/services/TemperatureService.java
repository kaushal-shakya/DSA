package lld2.observer.whethermonitoring.unsolved.services;

import lld2.observer.whethermonitoring.unsolved.utils.NotificationUtils;

public class TemperatureService {
    public void trigger(double value) {
        NotificationUtils.sendNotification("New value is " + value);
    }
}
