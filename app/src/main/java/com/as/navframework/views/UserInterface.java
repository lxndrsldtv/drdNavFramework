package com.as.navframework.views;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.as.navframework.NavApp;

/**
 * Created by lxndr.soldatov on 06/07/16.
 */

public class UserInterface {

    private Application application;

    public UserInterface (Application application) {
        this.application = application;
    }

    public void ask_user_for_authentication_credentials (IUserResponseHandler responseHandler) {
        Activity currentActivity = ((NavApp)application).getCurrentActivity();
        currentActivity.startActivity(new Intent(currentActivity, LoginActivity.class));
    }
}
