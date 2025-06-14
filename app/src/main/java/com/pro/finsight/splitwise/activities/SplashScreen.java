package com.pro.finsight.splitwise.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.pro.finsight.splitwise.R;
import com.pro.finsight.splitwise.utils.Constants;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;
    private static final String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash_screen);
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                SharedPreferences sharedPreferences = getSharedPreferences(Constants.FINSIGHT_SHARED_PREF, MODE_PRIVATE);
                boolean isLoggedIn = sharedPreferences.getBoolean(Constants.LOGIN_STATUS_KEY, false);
                Intent intent = null;
                if (isLoggedIn) {
                    // intent = new Intent(SplashScreen.this, Dashboard.class);
                    Log.v(TAG, "No Dashboard");
                } else {
                    intent = new Intent(SplashScreen.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }, SPLASH_TIME_OUT);
        } catch (Exception e) {
            Log.v("ERROR", e.getMessage());
        }
    }
}