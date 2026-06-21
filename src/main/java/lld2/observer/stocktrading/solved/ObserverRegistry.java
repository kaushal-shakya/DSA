package lld2.observer.stocktrading.solved;

public interface ObserverRegistry {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String stockName, double currentPrice);
}