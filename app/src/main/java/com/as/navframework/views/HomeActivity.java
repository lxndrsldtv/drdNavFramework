package com.as.navframework.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.as.navframework.Navigator;
import com.as.navframework.R;
import com.as.navframework.Transition;

public class HomeActivity extends AppCompatActivity implements Transition {

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

        ((Navigator)getApplication()).getFlow().setTransitionProvider(this);

        Log.v("NF",
              "HomeActivity.onCreate() time: " + System.currentTimeMillis() + " " +
              "Thread:" + Thread.currentThread().getId());

    }

    private void doSomethingAndNavigation() {
        ((Navigator)getApplication()).getFlow().navigateNext();
    }

    @Override
    public void onBackPressed() {
        ((Navigator)getApplication()).getFlow().navigatePrev();
    }

    private Class transitionDestination;

    @Override
    public void setDestination(Class destination) {
        transitionDestination = destination;
    }

    @Override
    public void perform() {
        startActivity(new Intent(this, transitionDestination));
    }


}

