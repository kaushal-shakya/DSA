package lld2.observer.whethermonitoring.solved.services;


import lld2.observer.whethermonitoring.solved.Observer;
import lld2.observer.whethermonitoring.solved.Publisher;
import lld2.observer.whethermonitoring.solved.utils.NotificationUtils;

public class TemperatureService implements Observer {

    private Publisher publisher;

    public TemperatureService() {}

    public TemperatureService(Publisher publisher) {
        this.publisher = publisher;
        this.publisher.addObserver(this);
    }

    public void trigger(double value) {
        NotificationUtils.sendNotification("New value is " + value);
    }

    @Override
    public void update(double value) {
        trigger(value);
    }
}