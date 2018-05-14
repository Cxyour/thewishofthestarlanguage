package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IVoucherCenterContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.DouDou;
import com.example.lenovo.thewishofthestarlanguage.model.entity.OrderMsgBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.VoucherBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.VoucherCenterPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;
import com.example.lenovo.thewishofthestarlanguage.view.personal.adapter.VoucherCenterListAdapter;

public class VoucherCenterActivity extends BaseActivity implements IVoucherCenterContract.IVoucherCenterView, View.OnClickListener {

    private ImageView voucher_center_return;
    private TextView voucher_center_bill;
    private TextView voucher_center_phone;
    private TextView voucher_center_balance;
    private ListView voucher_center_list;
    private SharedPreferences user;
    private SharedPreferences.Editor edit;
    private VoucherCenterPresenterImp voucherCenterPresenterImp;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
               String s= (String)msg.obj;
                Toast.makeText(VoucherCenterActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.activity_voucher_center;
    }

    @Override
    protected void init() {
        voucher_center_return = (ImageView) findViewById(R.id.voucher_center_return);
        voucher_center_bill = (TextView) findViewById(R.id.voucher_center_bill);
        voucher_center_phone = (TextView) findViewById(R.id.voucher_center_phone);
        voucher_center_balance = (TextView) findViewById(R.id.voucher_center_balance);
        voucher_center_list = (ListView) findViewById(R.id.voucher_center_list);

        voucher_center_return.setOnClickListener(this);
        voucher_center_bill.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        voucherCenterPresenterImp = new VoucherCenterPresenterImp(this);
        voucherCenterPresenterImp.loadData(user.getInt("user_id", 0));
    }

    @Override
    public void showData(VoucherBean voucherBean) {
        voucher_center_phone.setText(voucherBean.getData().getMobile());
        voucher_center_balance.setText(voucherBean.getData().getAmount() + " 星豆");
        VoucherCenterListAdapter voucherCenterListAdapter = new VoucherCenterListAdapter(voucherBean.getData().getList(),voucherCenterPresenterImp);
        voucher_center_list.setAdapter(voucherCenterListAdapter);
    }

    @Override
    public void showDouDou(DouDou douDou) {
        String message = douDou.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        String orderNo = douDou.getData().getOrderNo();
        voucherCenterPresenterImp.loadOrderMsgBean(orderNo);
    }

    @Override
    public void showOrderMsgBean(OrderMsgBean orderMsgBean) {
        String data = orderMsgBean.getData();
        final String orderInfo = data;   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(VoucherCenterActivity.this);
                String result = String.valueOf(alipay.payV2(orderInfo,true));

                Message msg = new Message();
                msg.what = 0;
                msg.obj = result;
                handler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.voucher_center_return:
                finish();
                break;
            case R.id.voucher_center_bill:

                break;

        }
    }
}
