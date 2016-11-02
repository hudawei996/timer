package com.example.huyongqiang.timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huyongqiang on 2016/11/2.
 * 定时器实现:Handler+Timer+TimerTask
 */
public class TimerThreeActivity extends Activity {
    TextView tvShow;
    private int i = 0;
    private int TIME = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_three);

        tvShow = (TextView) findViewById(R.id.tv_show);

        timer.schedule(task, 1000, 1000); // 1s后执行task,经过1s再次执行
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                tvShow.setText(Integer.toString(i++));
            }
            super.handleMessage(msg);
        }
    };
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            // 需要做的事:发送消息
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };
}
