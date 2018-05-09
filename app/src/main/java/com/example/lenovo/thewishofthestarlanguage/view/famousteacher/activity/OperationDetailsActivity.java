package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.OperationContract;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.OperationPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.OPerationAdapter;

public class OperationDetailsActivity extends BaseActivity implements OperationContract.view{

    private TextView xiangqing;
    private ImageView wok_detail_aty_more;
    private RecyclerView recyclerView;
    private EditText pinglun;
    private CheckBox home_valuable_list_item_collect_cb;
    private CheckBox home_valuable_list_item_praise_cb;
    private ImageView guanbi;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_operation_details;
    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        OperationPresenterImp operationPresenterImp = new OperationPresenterImp(this);
        operationPresenterImp.loadOperationBean(id);
    }

    private void initView() {

        xiangqing = (TextView) findViewById(R.id.xiangqing);
        wok_detail_aty_more = (ImageView) findViewById(R.id.wok_detail_aty_more);
        recyclerView = (RecyclerView) findViewById(R.id.workxiangqing);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        pinglun = (EditText) findViewById(R.id.pinglun);
        home_valuable_list_item_collect_cb = (CheckBox) findViewById(R.id.home_valuable_list_item_collect_cb);
        home_valuable_list_item_praise_cb = (CheckBox) findViewById(R.id.home_valuable_list_item_praise_cb);
        guanbi = (ImageView) findViewById(R.id.guanbi);
        guanbi.setOnClickListener(new View.OnClickListener() {
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
    public void showOperationBean(OperationBean operationBean) {
        OperationBean.DataBean data = operationBean.getData();
        OPerationAdapter oPerationAdapter = new OPerationAdapter(data);
        recyclerView.setAdapter(oPerationAdapter);

    }
}
