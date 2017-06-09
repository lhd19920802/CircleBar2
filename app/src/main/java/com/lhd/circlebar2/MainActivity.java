package com.lhd.circlebar2;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends Activity
{

    private CircleBar cb_main;
    private boolean isRunning=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb_main = (CircleBar)findViewById(R.id.cb_main);
    }

    public void startDownload(View v)
    {
        if(isRunning) {
            return;
        }
        isRunning=true;

        cb_main.setProgress(0);
        new Thread()
        {
            public void run()
            {

                int count=50;
                cb_main.setMax(count);
                for (int i = 0; i < count; i++)
                {
                    cb_main.setProgress(cb_main.getProgress()+1);
                    SystemClock.sleep(20);
                }
                isRunning=false;
            }

        }.start();
    }
}
