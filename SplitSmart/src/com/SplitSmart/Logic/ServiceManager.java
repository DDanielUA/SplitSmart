package com.SplitSmart.Logic;

import com.SplitSmart.Application.WelcomeScene.WelcomeView;

public class ServiceManager {

    private WelcomeService welcomeService;
    private UserService userService;

    private WelcomeView welcomeView;

    public ServiceManager(){
        this.welcomeService = new WelcomeService();
    }


}
