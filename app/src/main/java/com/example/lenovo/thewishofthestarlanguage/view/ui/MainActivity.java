package com.example.lenovo.thewishofthestarlanguage.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;

public class MainActivity extends AppCompatActivity {

    private TextView time;
    private int count = 3;
    private Runnable runnable;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (count == 0) {
                Intent intent = new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(intent);
                finish();
            } else {
                handler.postDelayed(runnable, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runnable = new Runnable() {
            @Override
            public void run() {
                count--;
                Message message = new Message();
                message.obj = count;
                handler.sendMessage(message);
            }
        };
        handler.postDelayed(runnable, 1000);
    }


}
