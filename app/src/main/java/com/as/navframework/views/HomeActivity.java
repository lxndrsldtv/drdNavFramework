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

public class HomeActivity extends AppCompatActivity implements NavigationPosition {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_tst);

        Button mSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mSignInButton.setText("Go to login");
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomethingAndNavigation();
            }
        });

        ((NavApp)getApplication()).getFlow().setTransitionProvider(this);

        Log.v("NF",
              "HomeActivity.onCreate() time: " + System.currentTimeMillis() + " " +
              "Thread:" + Thread.currentThread().getId());

    }

    private void doSomethingAndNavigation() {
        ((NavApp)getApplication()).getFlow().navigateNext();
    }

    @Override
    public void onBackPressed() {
        ((NavApp)getApplication()).getFlow().navigatePrev();
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

