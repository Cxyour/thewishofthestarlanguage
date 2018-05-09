package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.LiveIngContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.GoodOnClickBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LiveDetailsBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.LivePurchaseBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.LiveIngPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.LiveIngAdapterTwo;
import com.example.lenovo.thewishofthestarlanguage.view.personal.activity.LoginActivity;

import java.util.HashMap;

public class LiveDetailsActivity extends BaseActivity implements LiveIngContract.view {

    private RecyclerView live_recycle;
    private CheckBox live_shoucang;
    private TextView goumai;
    private int id;
    private ImageView back;
    private ImageView masterdetail_aty_share;
    private RelativeLayout titlelan;
    private TextView mai;
    private LiveIngPresenterImp liveIngPresenterImp;
    private LivePurchaseBean.DataBean data;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_live_details;
    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        liveIngPresenterImp = new LiveIngPresenterImp(this);
        liveIngPresenterImp.loadLivePurchaseBean(id);
    }

    private void initView() {
        live_recycle = (RecyclerView) findViewById(R.id.live_recycle);
        live_recycle.setLayoutManager(new LinearLayoutManager(this));
        live_shoucang =  findViewById(R.id.live_shoucang);
        goumai = (TextView) findViewById(R.id.mai);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showLiveBean(LiveDetailsBean liveDetailsBean) {

    }

    @Override
    public void showLivePurchaseBean(LivePurchaseBean livePurchaseBean) {
        data = livePurchaseBean.getData();
        LiveIngAdapterTwo liveIngAdapterTwo = new LiveIngAdapterTwo(data, id);
        live_recycle.setAdapter(liveIngAdapterTwo);
        shoucang(live_shoucang);
    }

    @Override
    public void showGoodBean(GoodOnClickBean goodOnClickBean) {

    }

    @Override
    public void showCancelthePraise(GoodOnClickBean goodOnClickBean) {

    }
    private void shoucang(final CheckBox checkBox){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               // TreaSureBean.DataBean.ArtcircleListBean.ListBean listBean = list.get(position);
                int id1 = data.getId();
              //  int id = listBean.getId();
                SharedPreferences sp = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                boolean isLogin = sp.getBoolean("isLogin", false);
                int xyxy_user_id = sp.getInt("xyxy_user_id", 0);
                HashMap<String, String> parmas = new HashMap<>();
                parmas.put("id", String.valueOf(id1));
                parmas.put("loginUserId", String.valueOf(xyxy_user_id));
                parmas.put("type", "直播课");
                if (isLogin==true){
                    if (isChecked==true) {
                        liveIngPresenterImp.Collection(parmas);
                        checkBox.setText(data.getSubscribeNum()+1+"");
                    }else {
                        liveIngPresenterImp.CancelTheCollection(parmas);
                        if (data.getSubscribeNum()!=0) {
                            checkBox.setText("");
                        }
                    }
                }else {
                    Intent intent = new Intent(LiveDetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
