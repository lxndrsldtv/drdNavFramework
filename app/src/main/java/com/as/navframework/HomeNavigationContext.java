package com.as.navframework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by al.so on 02.07.2016.
 */

public class HomeNavigationContext implements NavigationContext {

    private Activity context;

    public HomeNavigationContext(Activity context) {
        this.context = context;
    }

    @Override
    public NavigationContext perform(Transfer transfer) {
        //context.startActivity(new Intent(context, ));
        return null;
    }
}
