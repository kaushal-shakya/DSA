package lld2.observer.stocktrading.solved.services;


import lld2.observer.stocktrading.solved.Observer;
import lld2.observer.stocktrading.solved.Publisher;
import lld2.observer.stocktrading.solved.utils.NotificationUtils;

public class EmailService implements Observer {

    private Publisher publisher;

    public EmailService(){}

    public EmailService(Publisher publisher) {
        this.publisher = publisher;
        this.publisher.addObserver(this);
    }

    public void sendEmail(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        NotificationUtils.sendEmail(subject, message);
    }

    @Override
    public void send(String stockName, double currentPrice) {
      sendEmail(stockName, currentPrice);
    }
}