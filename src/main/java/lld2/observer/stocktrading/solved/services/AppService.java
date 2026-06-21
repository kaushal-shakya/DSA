package lld2.observer.stocktrading.solved.services;


import lld2.observer.stocktrading.solved.Observer;
import lld2.observer.stocktrading.solved.Publisher;
import lld2.observer.stocktrading.solved.utils.NotificationUtils;

public class AppService implements Observer {

    private Publisher publisher;

    public AppService(){}

    public AppService(Publisher publisher) {
        this.publisher = publisher;
        this.publisher.addObserver(this);
    }

    public void sendPush(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        NotificationUtils.sendPush(subject, message);
    }

    @Override
    public void send(String stockName, double currentPrice) {
        sendPush(stockName, currentPrice);
    }
}