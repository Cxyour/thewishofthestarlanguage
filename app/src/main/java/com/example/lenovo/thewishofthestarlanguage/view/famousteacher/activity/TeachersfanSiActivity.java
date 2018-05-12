package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.ITeacherFenSiContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TeacherFenSi;
import com.example.lenovo.thewishofthestarlanguage.presenter.TeacherFensiPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.TeacherFanSiAdapter;

import java.util.List;

public class TeachersfanSiActivity extends AppCompatActivity implements ITeacherFenSiContract.view {

    private ImageView back;
    private TextView name;
    private RelativeLayout title_rela;
    private LinearLayout shafa;
    private RecyclerView curric_recyle;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachersfan_si);
        initView();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        String nickname = intent.getStringExtra("nickname");
        name.setText( nickname+"的粉丝");
        TeacherFensiPresenterImp teacherFensiPresenterImp = new TeacherFensiPresenterImp(this);
        teacherFensiPresenterImp.loadTeacherFensi(id);
    }

    @Override
    public void showTeacherFensi(TeacherFenSi teacherFensi) {

        List<TeacherFenSi.DataBean.ListBean> list = teacherFensi.getData().getList();
        if (list.size()==0){
            shafa.setVisibility(View.VISIBLE);
        }
        TeacherFanSiAdapter teacherFanSiAdapter = new TeacherFanSiAdapter(list, id);
        curric_recyle.setAdapter(teacherFanSiAdapter);
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        name = (TextView) findViewById(R.id.name);
        title_rela = (RelativeLayout) findViewById(R.id.title_rela);
        shafa = (LinearLayout) findViewById(R.id.shafa);
        curric_recyle = (RecyclerView) findViewById(R.id.curric_recyle);
        curric_recyle.setLayoutManager(new LinearLayoutManager(this));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
