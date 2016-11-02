package com.example.huyongqiang.timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/**
 * handler定时器使用postDelyed实现
 *
 * @author Smalt
 */
public class TimerTwoActivity extends Activity {
    TextView tvShow;
    private int i = 0;
    private int TIME = 1000;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // handler自带方法实现定时器
            try {
                handler.postDelayed(this, TIME);
                tvShow.setText(Integer.toString(i++));

                System.out.println("do...");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("exception...");
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_two);
        tvShow = (TextView) findViewById(R.id.tv_show);

        handler.postDelayed(runnable, TIME); //每隔1s执行
    }


}
