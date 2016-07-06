package com.as.navframework;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.as.navframework.presenters.HomePresenter;

/**
 * Created by alex.soldatov on 23/06/16.
 */
public class NavApp extends Application {

    private NavigationFlow flow1;
    private NavigationFlow flow2;
    private NavigationFlow flow3;

    private HomePresenter homePresenter;

    private Activity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();

        homePresenter = new HomePresenter(null);

        flow1 = new NavFlow1(this);
        flow2 = new NavFlow2(this);
        flow3 = new NavFlow3();

        Log.v("NF",
              "NavApp.onCreate().exit time: " + System.currentTimeMillis() + " " +
              "Thread:" + Thread.currentThread().getId());

        //homePresenter = new HomePresenter(this);
        //homePresenter.startView();
    }

    public NavigationFlow getFlow() {
        //return flow1;
        //return flow2;
        return flow3;
    }

    public HomePresenter getHomePresenter() {
        return homePresenter;
    }

    public void setCurrentActivity (Activity activity) {
        currentActivity = activity;
    }

    public Activity getCurrentActivity () {
        return currentActivity;
    }

    //    public void navigateToLoginActivityStep1() {
//        startActivity(new Intent(getApplicationContext(), HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//    }
//
//    public void navigateToLoginActivityStep2() {
//        startActivity(new Intent(getApplicationContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//    }
//
//    public void navigateToLoginActivityStep3a() {
//        startActivity(new Intent(getApplicationContext(), PinCodeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//    }
//
//    public void navigateToLoginActivityStep3b() {
//        startActivity(new Intent(getApplicationContext(), TermsAndConditionsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//    }

}
