package com.aakash.jarvis.manifestotracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by chi6rag on 8/29/15.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // splash screen code
        Thread splashScreenThread = new Thread() {
            public void run(){
                try {
                    sleep(3*1000);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){

                }
            }
        };

        splashScreenThread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
