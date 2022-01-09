package com.SplitSmart.Logic.ActionObserver;

import java.util.ArrayList;
import java.util.List;

public class ActionAgency<T extends Enum> {
    private T event;
    private final List<ActionChannel<T>> subscribers = new ArrayList<>();

    public void subscribe(ActionChannel<T> subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(ActionChannel<T> unsubscriber){
        this.subscribers.remove(unsubscriber);
    }

    public void update(T eventHappened){
        this.event = eventHappened;
        for (ActionChannel<T> subscriber : subscribers){
            subscriber.Notify(this.event);
        }
    }

    public void update(T eventHappened, Object param){
        this.event = eventHappened;
        for (ActionChannel<T> subscriber : subscribers){
            subscriber.Notify(this.event, param);
        }
    }
}
