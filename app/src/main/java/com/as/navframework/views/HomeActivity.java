package com.as.navframework.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.as.navframework.NavApp;
import com.as.navframework.NavigationContext;
import com.as.navframework.NavigationPosition;
import com.as.navframework.R;
import com.as.navframework.Transfer;
import com.as.navframework.Transition;
import com.as.navframework.presenters.IActionHandler;
import com.as.navframework.presenters.IHomePresenter;

public class HomeActivity extends AppCompatActivity implements IHomeView, NavigationPosition, NavigationContext {

    private IHomePresenter homePresenter;
    private IActionHandler actionHandler;
    private Button mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_tst);

         mSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomethingAndNavigation();
            }
        });

        homePresenter = ((NavApp)getApplication()).getHomePresenter();
        homePresenter.setView(this);

        Log.v("NF",
              "HomeActivity.onCreate() time: " + System.currentTimeMillis() + " " +
              "Thread:" + Thread.currentThread().getId());

    }

    private void doSomethingAndNavigation() {
        actionHandler.handle((String)mSignInButton.getText());
    }

    @Override
    public void onBackPressed() {
        actionHandler.handle("GoBack");
    }

    @Override
    public void setActionName(String actionName) {
        mSignInButton.setText("Go to login");
    }

    @Override
    public void setActionHandler(IActionHandler actionHandler) {
        this.actionHandler = actionHandler;
    }

    @Override
    public NavigationContext perform(Transfer transfer) {
        return null;
    }

//    private Class transitionDestination;

//    @Override
//    public void setDestination(Class destination) {
//        transitionDestination = destination;
//    }

//    @Override
//    public NavigationContext perform(Transfer transfer) {
//        startActivity(new Intent(this, transitionDestination));
//    }


}

