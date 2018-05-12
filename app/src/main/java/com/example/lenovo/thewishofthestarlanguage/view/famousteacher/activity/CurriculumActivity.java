package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ITaskContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TaskBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.CurriculumPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.CurriculiumAdapter;

import java.util.List;

public class CurriculumActivity extends AppCompatActivity implements ITaskContract.view {

    private ImageView back;
    private TextView name;
    private LinearLayout shafa;
    private RecyclerView curric_recyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);
        initView();
        CurriculumPresenterImp curriculumPresenterImp = new CurriculumPresenterImp(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String nickname = intent.getStringExtra("nickname");
        name.setText(nickname+"的直播");
        curriculumPresenterImp.loadTaskBean(id);
    }

    @Override
    public void showTaskBean(TaskBean taskBean) {
        TaskBean.DataBean data = taskBean.getData();
        List<TaskBean.DataBean.ListBean> list = data.getList();
        CurriculiumAdapter curriculiumAdapter = new CurriculiumAdapter(list);
        curric_recyle.setAdapter(curriculiumAdapter);
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        name = (TextView) findViewById(R.id.name);
        shafa = (LinearLayout) findViewById(R.id.shafa);
        curric_recyle = (RecyclerView) findViewById(R.id.curric_recyle);
        curric_recyle.setLayoutManager(new LinearLayoutManager(this));
    }
}
