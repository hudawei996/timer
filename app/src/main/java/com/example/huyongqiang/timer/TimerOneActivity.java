package com.example.huyongqiang.timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * handler定时器
 *
 * @author Smalt
 *
 */
public class TimerOneActivity extends Activity {
    TextView tvShow;
    private int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_one);
        tvShow = (TextView) findViewById(R.id.tv_show);
        new Thread(new ThreadShow()).start();
    }

    // handler类接收数据
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            //如果接收到消息.what == 1
            if (msg.what == 1) {
                //更新显示
                tvShow.setText(Integer.toString(i++));

                System.out.println("receive....");
            }
        };
    };

    // 线程类
    class ThreadShow implements Runnable {
        @Override
        public void run() {
            //循环在次线程中，停1秒钟，发送消息
            while (true) {
                try {
                    //暂停1秒钟
                    Thread.sleep(1000);

                    //由message发送消息
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);

                    System.out.println("send...");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("thread error...");
                }
            }
        }
    }
}
