package com.as.navframework.presenters;

import android.content.Intent;
import android.util.Log;

import com.as.navframework.INavigator;
import com.as.navframework.NavApp;
import com.as.navframework.views.HomeActivity;
import com.as.navframework.views.IHomeView;

/**
 * Created by alex.soldatov on 24/06/16.
 */
public class HomePresenter implements IHomePresenter, IActionHandler{

    private IHomeView homeView;
    private INavigator navigator;

    public HomePresenter(INavigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void handle(String actionName) {
        Log.v("NF", "handling action " + actionName);
    }

    @Override
    public void setView(IHomeView homeView) {
        this.homeView = homeView;
        this.homeView.setActionName("Go to Login");
        this.homeView.setActionHandler(this);
    }
}
