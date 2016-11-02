package com.example.huyongqiang.timer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TimerOne(View view) {
        Intent intent = new Intent(this,TimerOneActivity.class);
        startActivity(intent);
    }

    public void TimerTwo(View view) {
        Intent intent = new Intent(this,TimerTwoActivity.class);
        startActivity(intent);
    }

    public void TimerThree(View view) {
        Intent intent = new Intent(this,TimerThreeActivity.class);
        startActivity(intent);
    }
}