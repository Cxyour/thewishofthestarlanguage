package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.OperationContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OperationBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.OperationPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.OPerationAdapter;

import java.util.HashMap;

public class OperationDetailsActivity extends BaseActivity implements OperationContract.view {

    private TextView xiangqing;
    private ImageView wok_detail_aty_more;
    private RecyclerView recyclerView;
    private EditText pinglun;
    private CheckBox home_valuable_list_item_collect_cb;
    private CheckBox home_valuable_list_item_praise_cb;
    private ImageView guanbi;
    private RecyclerView workxiangqing;
    private OperationPresenterImp operationPresenterImp;
    private Button fa;
    private String refId;
    private int id;
    private TextView xie;
    private LinearLayout linlin;


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
        id = intent.getIntExtra("id", 0);
        refId = intent.getStringExtra("refId");
        operationPresenterImp = new OperationPresenterImp(this);
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
        xie=findViewById(R.id.xie);
        fa = findViewById(R.id.fa);
        linlin=findViewById(R.id.linlin);
        guanbi = (ImageView) findViewById(R.id.guanbi);
        guanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linlin.setVisibility(View.VISIBLE);
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
    public void showOperationBean(final OperationBean operationBean) {
        final OperationBean.DataBean data = operationBean.getData();
        final OPerationAdapter oPerationAdapter = new OPerationAdapter(data, operationPresenterImp,refId,id);
        recyclerView.setAdapter(oPerationAdapter);
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if (pinglun.getText().toString()!=null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("refId", refId + "");
            SharedPreferences sp = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
            int user_id = sp.getInt("user_id", 0);
            map.put("userId", user_id + "");
            map.put("content", pinglun.getText().toString());
            map.put("refType", "作业评论");
            operationPresenterImp.loadReplyBean(map);
            operationPresenterImp.loadOperationBean(id);
            oPerationAdapter.notifyDataSetChanged();
            linlin.setVisibility(View.GONE);
            pinglun.setText("");
        }
            }
        });

    }

    @Override
    public void showGoodBean(GoodOnClickBean goodOnClickBean) {

    }

    @Override
    public void showCancelthePraise(GoodOnClickBean goodOnClickBean) {

    }

    @Override
    public void showReplyBean(ReplyBean replyBean) {
        Log.e("OperationDetailsActivit", replyBean.getMessage());
    }


}
