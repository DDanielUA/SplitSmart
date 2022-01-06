package com.SplitSmart.Logic.ActionObserver;

public class ActionChannel<T extends Enum> {
    private T event;

    public T getEvent(){
        return this.event;
    }

    public void Notify(T happenedEvent){
        this.event = happenedEvent;
    }
}
