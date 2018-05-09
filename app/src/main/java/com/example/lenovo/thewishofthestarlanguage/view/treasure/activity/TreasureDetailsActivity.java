package com.example.lenovo.thewishofthestarlanguage.view.treasure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IDetailsContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreasurteActiviyBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.DetailsPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.treasure.adapter.TreasureListViewAdapter;

public class TreasureDetailsActivity extends BaseActivity implements IDetailsContract.view {

    private ImageView fanhui;
    private RelativeLayout preview_title;
    private EditText pinglun;
    private CheckBox home_valuable_list_item_collect_cb;
    private CheckBox home_valuable_list_item_praise_cb2;
    private CheckBox home_valuable_list_item_praise_cb;
    private ListView detalist;

    private ImageView masterdetail_aty_share;
    private RelativeLayout titlelan;


    @Override
    protected int getLayoutId() {
        //宝典
        return R.layout.activity_preview_details;

    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadData() {

    }

    private void initView() {
        fanhui = (ImageView) findViewById(R.id.fanhui);
        preview_title = (RelativeLayout) findViewById(R.id.preview_title);
        pinglun = (EditText) findViewById(R.id.pinglun);
        home_valuable_list_item_collect_cb = (CheckBox) findViewById(R.id.home_valuable_list_item_collect_cb);
        home_valuable_list_item_praise_cb2 = (CheckBox) findViewById(R.id.home_valuable_list_item_praise_cb2);

        home_valuable_list_item_praise_cb = (CheckBox) findViewById(R.id.home_valuable_list_item_praise_cb);
        detalist = (ListView) findViewById(R.id.detalist);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        DetailsPresenterImp detailsPresenterImp = new DetailsPresenterImp(this);
        detailsPresenterImp.loadPreviewActiviyBean(id);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });

    }

    private void submit() {
        // validate
        String pinglunString = pinglun.getText().toString().trim();
        if (TextUtils.isEmpty(pinglunString)) {
            Toast.makeText(this, "写评论", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void showPreviewActiviyBean(TreasurteActiviyBean previewActiviyBean) {
        TreasurteActiviyBean.DataBean.ArtcircleBean artcircle = previewActiviyBean.getData().getArtcircle();
        TreasureListViewAdapter previewListViewAdapter = new TreasureListViewAdapter(artcircle);
        detalist.setAdapter(previewListViewAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
