package com.example.lenovo.thewishofthestarlanguage.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;

public class WorkWorkActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhao_qing_ta__fu_dao);
        TextView viewById = findViewById(R.id.publishredactwokdetail_cancle);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
