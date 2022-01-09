package com.SplitSmart.Logic.ActionObserver;

public class ActionChannel<T extends Enum> {
    private T event;

    public T getEvent(){
        return this.event;
    }

    public void Notify(T eventHappened){
        this.event = eventHappened;
    }

    public void Notify(T eventHappened, Object param){
        this.event = eventHappened;
    }
}
