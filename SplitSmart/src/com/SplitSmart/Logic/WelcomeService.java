package com.SplitSmart.Logic;

import com.SplitSmart.Application.WelcomeScene.FeedbackView;
import com.SplitSmart.Application.WelcomeScene.LoginView;
import com.SplitSmart.Application.WelcomeScene.RegView;
import com.SplitSmart.Application.WelcomeScene.WelcomeView;
import com.SplitSmart.Logic.ActionObserver.ActionAgent;
import com.SplitSmart.Logic.ActionObserver.ActionListener;
import com.SplitSmart.Logic.ActionObserver.ServiceAction;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.PersonRepository;

public class WelcomeService extends ActionListener<WelcomeAction> {

    private final SplitSmartContext ctx = SplitSmartContext.GetInstance();
    private final PersonRepository perRepo = new PersonRepository(ctx);

    private final ActionAgent<ServiceAction> serviceObserver;
    private final ActionAgent<WelcomeAction> observer;

    //Runtime specific data
    private boolean isErrorLogIn = false;

    public WelcomeService(ActionAgent<ServiceAction> sObserver){
        this.serviceObserver = sObserver;

        this.observer = new ActionAgent<>();
        observer.subscribe(this);

    }

    public void InitiateWelcomeService(){
        provideWelcomeView();
    }

    @Override
    public void Notify(WelcomeAction eventHappened) {
        super.Notify(eventHappened);
        switch (eventHappened){
            case Default -> provideWelcomeView();
            case InitiateLogIn -> provideLogInView();
            case InitiateRegister -> provideRegisterView();
        }
    }

    @Override
    public void Notify(WelcomeAction eventHappened, Object param) {
        super.Notify(eventHappened, param);
        switch (eventHappened){
            case AttemptRegister -> registerUser((Person)param);
            case AttemptLogIn -> logInUser((Person)param);
        }
    }

    private void provideWelcomeView(){
        WelcomeView welcomeView = new WelcomeView(this.observer);
        welcomeView.displayView();
    }

    private void provideLogInView(){
        LoginView loginView = new LoginView(this.observer, new Person(), this.isErrorLogIn);
        loginView.displayView();
    }

    private void provideRegisterView(){
        RegView registerView = new RegView(this.observer, new Person());
        registerView.displayView();
    }

    private void provideFeedbackView(Person person){
        FeedbackView feedbackView = new FeedbackView(this.observer, person);
        feedbackView.displayView();
    }

    private void registerUser(Person person){
        person.setPersonId(ctx.NextPersonId);
        ctx.NextPersonId++;

        this.perRepo.Insert(person);

        provideFeedbackView(person);
    }

    private void logInUser(Person person){

        for (Person p : this.perRepo.GetAll()){
            if (p.getPersonId() == person.getPersonId()) {
                if (p.getName().equals(person.getName())){
                    person = p;
                    break;
                }
            }
        }
        if (person.getEmail() == null){
            this.isErrorLogIn = true;

            provideLogInView();
        }
        else{
            serviceObserver.update(ServiceAction.LoggedIn, person);
        }
    }
}
