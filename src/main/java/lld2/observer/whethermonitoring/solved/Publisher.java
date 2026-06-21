package lld2.observer.whethermonitoring.solved;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher implements ObserverRegistry {

    private List<Observer> subscribers = new ArrayList<>();

    public void addObserver(Observer observer){
        subscribers.add(observer);
    }

    public void removeObserver(Observer observer){
        subscribers.remove(observer);
    }

    public void notifyObservers(double value){
        for (Observer observer : subscribers) {
            observer.update(value);
        }
    }
}