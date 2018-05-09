package com.example.lenovo.thewishofthestarlanguage.view.preview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IPreviewDetailsContact;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PreviewActivityBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.PreviewActivityPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.preview.adapter.PreviewListViewAdapter;

public class PrevieDetailsActivity extends AppCompatActivity implements IPreviewDetailsContact.view {

    private ImageView shoucang;
    private TextView yuyue;
    private LinearLayout prvie_liner;
    private ListView preview_list;
    private int id;
    private ImageView back;
    private ImageView masterdetail_aty_share;
    private RelativeLayout titlelan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previe_details);
        initView();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        PreviewActivityPresenterImp previewActivityPresenterImg = new PreviewActivityPresenterImp(this);
        previewActivityPresenterImg.loadPreviewActivityBean(id);
    }

    @Override
    public void showPreviewActivityBean(PreviewActivityBean previewActivityBean) {
        PreviewActivityBean.DataBean data = previewActivityBean.getData();
        PreviewListViewAdapter previewListViewAdapter = new PreviewListViewAdapter(data, id);
        preview_list.setAdapter(previewListViewAdapter);
    }

    private void initView() {
        shoucang = (ImageView) findViewById(R.id.shoucang);
        yuyue = (TextView) findViewById(R.id.yuyue);
        prvie_liner = (LinearLayout) findViewById(R.id.prvie_liner);
        preview_list = (ListView) findViewById(R.id.preview_list);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(PrevieDetailsActivity.this, "hhahahsdassadasdasd", Toast.LENGTH_SHORT).show();
            }
        });
        masterdetail_aty_share = (ImageView) findViewById(R.id.masterdetail_aty_share);

        titlelan = (RelativeLayout) findViewById(R.id.titlelan);

    }
}
