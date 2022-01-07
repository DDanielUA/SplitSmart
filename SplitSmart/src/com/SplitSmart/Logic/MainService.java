package com.SplitSmart.Logic;

import com.SplitSmart.Application.MainScene.MainView;
import com.SplitSmart.Application.MainScene.NewView;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.ActionChannel;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Logic.ActionObserver.ServiceAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;
import com.SplitSmart.Repository.Data.SplitSmartContext;

import java.util.ArrayList;

public class MainService extends ActionChannel<UserAction> {

    private final SplitSmartContext ctx = SplitSmartContext.GetInstance();

    private final ActionAgency<ServiceAction> serviceObserver;
    private final ActionAgency<UserAction> observer;

    private Person user;
    private ArrayList<Receipt> receipts;

    public MainService(ActionAgency<ServiceAction> sObserver){
        this.serviceObserver = sObserver;
        this.observer = new ActionAgency<>();
        observer.subscribe(this);
    }

    @Override
    public void Notify(UserAction happenedEvent) {
        super.Notify(happenedEvent);
    }

    public void InitiateService(){
        provideView("Main");
    }

    private void provideView(String neededView){
        switch (neededView){
            case "Main" -> {
                MainView mainView = new MainView(this.observer, user, receipts);
                mainView.displayView();
            }
            case "AddReceipt" -> {
                NewView newView = new NewView(this.observer, user, receipts);
                newView.displayView();
            }
            case "DeleteUser" -> {
                int c = 15;
            }
            case "ShowReceipt" -> {
                int d = 20;
            }
            case "ShowSummary" -> {
                int e = 25;
            }
            case "LogOut" -> {
                this.serviceObserver.update(ServiceAction.LoggedOut);
            }
        }
    }
}
