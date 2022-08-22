package com.codecool.testautomation.config;

import com.codecool.testautomation.page.LoginPage;

public class LoginSingleton {

    private static LoginPage loginPage = null;

    private LoginSingleton(){};

    public static LoginPage getLoginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
