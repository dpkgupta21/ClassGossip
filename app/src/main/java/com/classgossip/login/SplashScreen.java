package com.classgossip.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.classgossip.R;
import com.classgossip.utilities.AppConstants;
import com.classgossip.utilities.BaseActivity;

public class SplashScreen extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //holds the screen for specific period of time.
        new Handler().postDelayed(splashRunnable, AppConstants.SPLASH_SCREEN_WAITING);
    }

    //this runnable starts login activity
    Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            SplashScreen.this.startActivity(intent);
            SplashScreen.this.finish();
        }
    };
}
