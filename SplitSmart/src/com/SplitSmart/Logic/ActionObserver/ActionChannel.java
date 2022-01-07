package com.SplitSmart.Logic.ActionObserver;

public class ActionChannel<T extends Enum> {
    private T event;
    private Object param;

    public T getEvent(){
        return this.event;
    }

    public void Notify(T happenedEvent){
        this.event = happenedEvent;
    }

    public void Notify(T eventHappened, Object param){
        this.event = eventHappened;
        this.param = param;
    }
}
