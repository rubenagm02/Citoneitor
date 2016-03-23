package com.citoneitor.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.citoneitor.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new TiempoSplashScreen(this).run();
    }

    private class TiempoSplashScreen extends Thread {

        private Activity activity;

        private TiempoSplashScreen(Activity activity) {
            this.activity = activity;
        }

        public void run () {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(activity, Principal.class);
            activity.startActivity(intent);
        }
    }
}
