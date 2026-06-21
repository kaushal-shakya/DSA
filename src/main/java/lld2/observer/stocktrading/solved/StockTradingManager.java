package lld2.observer.stocktrading.solved;

public class StockTradingManager extends Publisher {

    private String stockName;
    private double currentPrice;
    private double notificationThreshold;

    // private EmailService emailService = new EmailService(publisher);

    // private SmsService smsService = new SmsService(publisher);
    // private AppService appService = new AppService(publisher);

    // DO NOT MODIFY THIS CONSTRUCTOR
    public StockTradingManager(String stockName, double initialPrice, double notificationThreshold) {
        this.stockName = stockName;
        this.currentPrice = initialPrice;
        this.notificationThreshold = notificationThreshold;
    }
    // DO NOT MODIFY THIS CONSTRUCTOR



    public void updateStockPrice(double newPrice) {
        currentPrice = newPrice;
        if (currentPrice > notificationThreshold) {
            // emailService.sendEmail(stockName, currentPrice);
            // smsService.sendSMS(stockName, currentPrice);
            // appService.sendPush(stockName, currentPrice);
            notifyObservers(stockName, newPrice);
        }
    }
}