package com.as.navframework.views;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.as.navframework.R;

public class SplashActivity extends AppCompatActivity {
    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mContentView = findViewById(R.id.fullscreen_content);

        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

        Log.v("NF",
              "SplashActivity.onCreate() time: " + System.currentTimeMillis() + " " +
              "Thread:" + Thread.currentThread().getId());
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("NF",
              "SplashActivity.onStart() time: " + System.currentTimeMillis() + " " +
              "Thread:" + Thread.currentThread().getId());

        finish();
        //finishActivity(0);
        //finishAndRemoveTask();
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        Log.v("NF",
//                "SplashActivity.onPause() time: " + System.currentTimeMillis() + " " +
//                        "Thread:" + Thread.currentThread().getId());
//
//        finish();
//    }
}
