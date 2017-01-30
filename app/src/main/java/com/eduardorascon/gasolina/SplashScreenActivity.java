package com.eduardorascon.gasolina;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.eduardorascon.gasolina.sqlite.DatabaseHandler;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        //databaseHandler.setup();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);

                // close this activity
                finish();
            }
        }, SPLASH_SCREEN_TIME);
    }
}