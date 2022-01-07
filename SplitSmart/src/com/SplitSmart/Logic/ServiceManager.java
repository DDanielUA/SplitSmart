package com.SplitSmart.Logic;

import com.SplitSmart.Logic.ActionObserver.ActionChannel;
import com.SplitSmart.Logic.ActionObserver.ProgramAction;

public class ServiceManager extends ActionChannel<ProgramAction> {

    public ServiceManager(){
        WelcomeService();
    }

    @Override
    public void Notify(ProgramAction happenedEvent) {
        super.Notify(happenedEvent);
        switch (happenedEvent){
            case Default -> Nothing();
            case LoggedIn -> MainService();
        }
    }

    private void Nothing(){

    }

    private void WelcomeService(){
        WelcomeService welcomeService = new WelcomeService();
        welcomeService.InitiateWelcomeService();
    }

    private void MainService(){
        MainService mainService = new MainService();
        mainService.InitiateService();
    }
}
