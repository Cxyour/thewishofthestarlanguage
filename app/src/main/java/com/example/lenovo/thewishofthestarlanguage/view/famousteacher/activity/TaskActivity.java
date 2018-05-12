package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ITaskContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TaskBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.TaskPresenterImp;

import java.util.List;

public class TaskActivity extends AppCompatActivity implements ITaskContract.view {

    private LinearLayout shafa;
    private ImageView back;
    private TextView name;
    private RecyclerView recycler_curr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        initView();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String nickname = intent.getStringExtra("nickname");
        name.setText( nickname

        );
        TaskPresenterImp taskPresenterImp = new TaskPresenterImp(this);
        taskPresenterImp.loadTaskBean(id);
    }

    @Override
    public void showTaskBean(TaskBean taskBean) {
        List<TaskBean.DataBean.ListBean> list = taskBean.getData().getList();
        if (list.size() == 0) {
            shafa.setVisibility(View.VISIBLE);
        }
    }

    private void initView() {
        shafa = (LinearLayout) findViewById(R.id.shafa);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        name = (TextView) findViewById(R.id.name);

        recycler_curr = (RecyclerView) findViewById(R.id.recycler_curr);
      ;
    }
}
