package com.SplitSmart.Logic;

import com.SplitSmart.Application.LoginView;
import com.SplitSmart.Application.RegView;
import com.SplitSmart.Application.WelcomeView;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.ActionChannel;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;

public class WelcomeService extends ActionChannel<WelcomeAction> {

    private WelcomeView welcomeView;
    private LoginView loginView;
    private RegView registerView;

    private ActionAgency<WelcomeAction> observer;

    public WelcomeService(){
        this.observer = new ActionAgency<>();
        observer.subscribe(this);

        ProvideView("Welcome");
    }

    private void ProvideView(String neededView){
        switch (neededView){
            case "Welcome" -> {
                this.welcomeView = new WelcomeView(this.observer);
                welcomeView.displayView();
            }
            case "LogIn" -> {
                this.loginView = new LoginView();
                loginView.displayView();
            }
            case "Register" -> {
                this.registerView = new RegView();
                registerView.displayView();
            }
        }
    }

    @Override
    public void notify(WelcomeAction happenedEvent) {
        super.notify(happenedEvent);
        switch (happenedEvent){
            case LogInPresssed -> {
                ProvideView("LogIn");
            }
            case RegisterPressed -> {
                ProvideView("Register");
            }
        }
    }
}
