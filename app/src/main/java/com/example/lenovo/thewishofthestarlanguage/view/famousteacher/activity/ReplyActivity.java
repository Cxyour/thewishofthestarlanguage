package com.example.lenovo.thewishofthestarlanguage.view.famousteacher.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IReplyContract;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.ReplyTwoBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.OperationPresenterImp;
import com.example.lenovo.thewishofthestarlanguage.presenter.ReplyPresenterImg;
import com.example.lenovo.thewishofthestarlanguage.view.famousteacher.adapter.ReplyAdapter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ReplyActivity extends AppCompatActivity implements View.OnClickListener, IReplyContract.view {

    private EditText pinglun;
    private Button fa;
    private LinearLayout linlin;
    private RecyclerView reply_recycle;
    private int id;
    private OperationPresenterImp operationPresenterImp;
    private int index;
    private ReplyAdapter replyAdapter;
    private ImageView pohot;
    private TextView name;
    private TextView contentMeg;
    private TextView sj;
    private CheckBox opera_zan;
    private TextView huifu;
    private RelativeLayout replay_title;
    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年
    private ReplyPresenterImg replyPresenterImg;

    private HashMap<String, String> map;
    private ReplyAdapter replyAdapter1;
    private List<ReplyTwoBean.DataBean.CommentsBean.ListBean> list;
    private int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        initView();
        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);
        pid = intent.getIntExtra("id", 0);

        replyPresenterImg = new ReplyPresenterImg(this);
        map = new HashMap<>();
        map.put("homewokId", index + "");
        map.put("commentsId", pid + "");
        replyPresenterImg.loadReplyTwoBean(map);

    }

    private void initView() {
        pinglun = (EditText) findViewById(R.id.pinglun);
        fa = (Button) findViewById(R.id.fa);
        linlin = (LinearLayout) findViewById(R.id.linlin);

        fa.setOnClickListener(this);
        reply_recycle = (RecyclerView) findViewById(R.id.reply_recycle);
        reply_recycle.setLayoutManager(new LinearLayoutManager(this));
        reply_recycle.setOnClickListener(this);
        pohot = (ImageView) findViewById(R.id.pohot);
        pohot.setOnClickListener(this);
        name = (TextView) findViewById(R.id.name);
        name.setOnClickListener(this);
        contentMeg = (TextView) findViewById(R.id.contentMeg);
        contentMeg.setOnClickListener(this);
        sj = (TextView) findViewById(R.id.sj);
        sj.setOnClickListener(this);
        opera_zan = (CheckBox) findViewById(R.id.opera_zan);
        opera_zan.setOnClickListener(this);
        huifu = (TextView) findViewById(R.id.huifu);
        huifu.setOnClickListener(this);
        replay_title = (RelativeLayout) findViewById(R.id.replay_title);
        replay_title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fa:

                if (pinglun.getText().toString() != "") {
                    SharedPreferences sp = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                    int user_id = sp.getInt("user_id", 0);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("pid",pid+"");
                    map.put("userId",user_id+"");
                    map.put("content",pinglun.getText().toString());
                    map.put("refId",index+"");
                    map.put("status",0+"");
                //    list.get(0).
                   replyPresenterImg.loadReplyBean(map);
                }
                break;
        }
    }

    private void submit() {
        // validate
        String pinglunString = pinglun.getText().toString().trim();
        if (TextUtils.isEmpty(pinglunString)) {
            Toast.makeText(this, "pinglunString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }


    @Override
    public void
    showReplyTwoBean(ReplyTwoBean replyTwoBean) {
        Toast.makeText(this, replyTwoBean.getMessage(), Toast.LENGTH_SHORT).show();
        list = replyTwoBean.getData().getComments().getList();
        replyAdapter1 = new ReplyAdapter(list);
        reply_recycle.setAdapter(replyAdapter1);
        ReplyTwoBean.DataBean.CommentBean comment = replyTwoBean.getData().getComment();
   //     refId = comment.getUserId();
        contentMeg.setText(comment.getContent());
          name.setText(comment.getNickname());
       opera_zan.setText(comment.getIsPraise()+"");
        Glide.with(this).load(comment.getPhoto()).asBitmap().into(new BitmapImageViewTarget(pohot){
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                pohot.setImageDrawable(roundedBitmapDrawable);
            }
        });
        Date date = new Date(comment.getCreateDate());
        String timeFormatText = getTimeFormatText(date);
        sj.setText(timeFormatText);
    }

    @Override
    public void showReplyBean(ReplyBean replyBean) {
        Toast.makeText(this, replyBean.getMessage(), Toast.LENGTH_SHORT).show();
        replyPresenterImg.loadReplyTwoBean(map);
        replyAdapter.notifyDataSetChanged();
    }

    public static String getTimeFormatText(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

}
