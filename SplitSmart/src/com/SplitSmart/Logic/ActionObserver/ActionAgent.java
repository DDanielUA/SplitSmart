package com.SplitSmart.Logic.ActionObserver;

import java.util.ArrayList;
import java.util.List;

public class ActionAgent<T extends Enum> {
    private T event;
    private final List<ActionListener<T>> subscribers = new ArrayList<>();

    public void subscribe(ActionListener<T> subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(ActionListener<T> unsubscriber){
        this.subscribers.remove(unsubscriber);
    }

    public void update(T eventHappened){
        this.event = eventHappened;
        for (ActionListener<T> subscriber : subscribers){
            subscriber.Notify(this.event);
        }
    }

    public void update(T eventHappened, Object param){
        this.event = eventHappened;
        for (ActionListener<T> subscriber : subscribers){
            subscriber.Notify(this.event, param);
        }
    }
}
