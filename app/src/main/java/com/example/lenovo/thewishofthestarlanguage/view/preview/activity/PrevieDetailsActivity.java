package com.example.lenovo.thewishofthestarlanguage.view.preview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previe_details);
        initView();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        PreviewActivityPresenterImp previewActivityPresenterImg = new PreviewActivityPresenterImp(this);
        previewActivityPresenterImg.loadPreviewActivityBean(id);
    }

    @Override
    public void showPreviewActivityBean(PreviewActivityBean previewActivityBean) {
        PreviewActivityBean.DataBean data = previewActivityBean.getData();
        PreviewListViewAdapter previewListViewAdapter = new PreviewListViewAdapter(data);
        preview_list.setAdapter(previewListViewAdapter);
    }

    private void initView() {
        shoucang = (ImageView) findViewById(R.id.shoucang);
        yuyue = (TextView) findViewById(R.id.yuyue);
        prvie_liner = (LinearLayout) findViewById(R.id.prvie_liner);
        preview_list = (ListView) findViewById(R.id.preview_list);
    }
}
