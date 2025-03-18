package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class TaskSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Task status changed to: " + status);
        }
    }
}