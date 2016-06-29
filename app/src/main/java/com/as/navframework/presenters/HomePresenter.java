package com.as.navframework.presenters;

import android.app.Application;
import android.content.Intent;

import com.as.navframework.Navigator;
import com.as.navframework.views.HomeActivity;

/**
 * Created by alex.soldatov on 24/06/16.
 */
public class HomePresenter {

    Navigator transitionProvider;

    public HomePresenter(Navigator transitionProvier) {
        this.transitionProvider = transitionProvier;
    }

    public void startView() {
        transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

}
