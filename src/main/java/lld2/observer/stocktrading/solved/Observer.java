package lld2.observer.stocktrading.solved;

public interface Observer {
    void send(String stockName, double currentPrice);
}
