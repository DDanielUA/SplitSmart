package com.SplitSmart.Logic;

import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.ActionChannel;
import com.SplitSmart.Logic.ActionObserver.ServiceAction;
import com.SplitSmart.Model.Person;

public class ServiceManager extends ActionChannel<ServiceAction> {

    private final ActionAgency<ServiceAction> serviceObserver;

    public ServiceManager(){
        this.serviceObserver = new ActionAgency<>();
        serviceObserver.subscribe(this);
        this.serviceObserver.update(ServiceAction.Welcome);
    }

    @Override
    public void Notify(ServiceAction happenedEvent) {
        super.Notify(happenedEvent);
        switch (happenedEvent){
            case Default -> Nothing();
            case Welcome, LoggedOut -> provideWelcomeService();
        }
    }

    @Override
    public void Notify(ServiceAction happenedEvent, Object param) {
        super.Notify(happenedEvent);
        provideMainService(param);
    }

    private void Nothing(){

    }

    private void provideWelcomeService(){
        WelcomeService welcomeService = new WelcomeService(this.serviceObserver);
        welcomeService.InitiateWelcomeService();
    }

    private void provideMainService(Object param){
        if (param instanceof Person){
            MainService mainService = new MainService(this.serviceObserver);
            mainService.InitiateService();
        }
    }
}
