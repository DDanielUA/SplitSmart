package com.SplitSmart.Logic;

import com.SplitSmart.Application.WelcomeView;

public class ServiceManager {

    private LogInService loginService;
    private ReceiptService receiptService;

    private WelcomeView welcomeView;

    public ServiceManager(){
        loginService = new LogInService();
    }

}
