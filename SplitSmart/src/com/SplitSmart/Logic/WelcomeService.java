package com.SplitSmart.Logic;

import com.SplitSmart.Application.WelcomeScene.FeedbackView;
import com.SplitSmart.Application.WelcomeScene.LoginView;
import com.SplitSmart.Application.WelcomeScene.RegView;
import com.SplitSmart.Application.WelcomeScene.WelcomeView;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.ActionChannel;
import com.SplitSmart.Logic.ActionObserver.ServiceAction;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.PersonRepository;

public class WelcomeService extends ActionChannel<WelcomeAction> {

    private final SplitSmartContext ctx = SplitSmartContext.GetInstance();

    private final ActionAgency<ServiceAction> serviceObserver;
    private final ActionAgency<WelcomeAction> observer;

    private Person person;
    private boolean isErrorLogIn = false;

    public WelcomeService(ActionAgency<ServiceAction> sObserver){
        this.serviceObserver = sObserver;

        this.observer = new ActionAgency<>();
        observer.subscribe(this);

    }

    public void InitiateWelcomeService(){
        provideView("Welcome");
    }

    @Override
    public void Notify(WelcomeAction happenedEvent) {
        super.Notify(happenedEvent);
        switch (happenedEvent){
            case Default -> provideView("Welcome");
            case InitiateLogIn -> provideView("LogIn");
            case InitiateRegister -> provideView("Register");
            case AttemptLogIn -> logInUser();
            case AttemptRegister -> registerUser();
            case ProvideFeedback -> provideView("Feedback");
        }
    }

    private void provideView(String neededView){
        switch (neededView){
            case "Welcome" -> {
                WelcomeView welcomeView = new WelcomeView(this.observer);
                welcomeView.displayView();
            }
            case "LogIn" -> {
                this.person = new Person();
                LoginView loginView = new LoginView(this.observer, this.person, this.isErrorLogIn);
                loginView.displayView();
            }
            case "Register" -> {
                this.person = new Person();
                RegView registerView = new RegView(this.observer, this.person);
                registerView.displayView();
            }
            case "Feedback" -> {
                FeedbackView feedbackView = new FeedbackView(this.observer, this.person);
                feedbackView.displayView();
            }
        }
    }

    private void registerUser(){
        this.person.setPersonId(ctx.nextPersonId);
        ctx.nextPersonId++;

        PersonRepository personRepo = new PersonRepository(ctx);
        personRepo.Insert(this.person);
        ctx.SaveSets();

        provideView("Feedback");
    }

    private void logInUser(){
        PersonRepository personRepo = new PersonRepository(ctx);

        for (Person p : personRepo.GetAll()){
            if (p.getPersonId() == this.person.getPersonId()) {
                if (p.getName().equals(this.person.getName())){
                    this.person = p;
                    break;
                }
            }
        }
        // null it out if there is no match
        if (this.person.getEmail() == null){
            this.person = new Person();
            this.isErrorLogIn = true;

            provideView("LogIn");
        }
        else{
            serviceObserver.update(ServiceAction.LoggedIn, this.person);
        }
    }
}
