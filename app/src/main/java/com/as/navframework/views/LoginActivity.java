package com.as.navframework.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;

import com.as.navframework.Navigator;
import com.as.navframework.R;
import com.as.navframework.Transition;

public class LoginActivity extends AppCompatActivity implements Transition {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_tst);

        Button mSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mSignInButton.setText("Login");
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomethingAndNavigation();
            }
        });

        ((Navigator)getApplication()).getFlow().setTransitionProvider(this);

    }

    private void doSomethingAndNavigation() {
        ((Navigator)getApplication()).getFlow().navigateNext();
        finish();
    }

    @Override
    public void onBackPressed() {
        ((Navigator)getApplication()).getFlow().navigatePrev();
        finish();
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

