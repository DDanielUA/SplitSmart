package com.SplitSmart.Logic;

import com.SplitSmart.Logic.ActionObserver.ActionAgent;
import com.SplitSmart.Logic.ActionObserver.ActionListener;
import com.SplitSmart.Logic.ActionObserver.ServiceAction;
import com.SplitSmart.Model.Person;

public class ServiceManager extends ActionListener<ServiceAction> {

    private final ActionAgent<ServiceAction> serviceObserver;

    public ServiceManager(){
        this.serviceObserver = new ActionAgent<>();
        serviceObserver.subscribe(this);
        this.serviceObserver.update(ServiceAction.Welcome);
    }

    @Override
    public void Notify(ServiceAction eventHappened) {
        super.Notify(eventHappened);
        switch (eventHappened){
            case Welcome, LoggedOut -> provideWelcomeService();
        }
    }

    @Override
    public void Notify(ServiceAction eventHappened, Object param) {
        super.Notify(eventHappened);
        provideMainService(param);
    }

    private void provideWelcomeService(){
        WelcomeService welcomeService = new WelcomeService(this.serviceObserver);
        welcomeService.InitiateWelcomeService();
    }

    private void provideMainService(Object param){
        if (param instanceof Person){
            MainService mainService = new MainService(this.serviceObserver, (Person)param);
            mainService.InitiateService();
        }
    }
}
