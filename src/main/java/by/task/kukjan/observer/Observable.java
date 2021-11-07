package by.task.kukjan.observer;

public interface Observable {
    void attach(ConeObserver observer);

    void detach();

    void notifyObservers();
}
