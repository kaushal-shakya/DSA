package lld2.observer.whethermonitoring.unsolved;

public interface ObserverRegistry {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(double value);
}
