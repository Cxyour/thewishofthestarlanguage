package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.contact.IPerFectInforMationContact;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.model.entity.PerFectInforBean;
import com.example.lenovo.thewishofthestarlanguage.presenter.IPerFectInforPresenter;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PerfectInformationActivity extends BaseActivity implements View.OnClickListener,IPerFectInforMationContact.IPerFectInlView {

    private ImageView perfect_information_return;
    private ImageView perfect_information_album;
    private ImageView perfect_information_camera;
    private EditText perfect_information_name;
    private ImageView perfect_information_close_name;
    private RadioButton perfect_information_man;
    private RadioButton perfect_information_women;
    private RadioGroup perfect_information_rg;
    private EditText perfect_information_password;
    private ImageView perfect_information_close_password;
    private Button perfect_information_finish;
    private String sex;
    String imageId_xiangCe;
    Uri uri_xiangCe;
    private static final int PHOTO_REQUEST_GALLERY = 2;
    private static final int PHOTO_REQUEST_CUT = 3;
    private File tempFile = new File(Environment.getExternalStorageDirectory(),
            getPhotoFileName());

    @Override
    protected int getLayoutId() {
        return R.layout.activity_perfect_information;
    }

    @Override
    protected void init() {
        perfect_information_return = findViewById(R.id.perfect_information_return);
        perfect_information_album = findViewById(R.id.perfect_information_album);
        perfect_information_album.setOnClickListener(this);
        perfect_information_camera = findViewById(R.id.perfect_information_camera);
        perfect_information_name = findViewById(R.id.perfect_information_name);
        perfect_information_close_name = findViewById(R.id.perfect_information_close_name);
        perfect_information_man = findViewById(R.id.perfect_information_man);
        perfect_information_man.setOnClickListener(this);
        perfect_information_women = findViewById(R.id.perfect_information_women);
        perfect_information_women.setOnClickListener(this);
        perfect_information_rg = findViewById(R.id.perfect_information_rg);
        perfect_information_password = findViewById(R.id.perfect_information_password);
        perfect_information_close_password = findViewById(R.id.perfect_information_close_password);
        perfect_information_finish = findViewById(R.id.perfect_information_finish);
        perfect_information_finish.setOnClickListener(this);
        perfect_information_return.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    // 使用系统当前日期加以调整作为照片的名称
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.perfect_information_man:
                perfect_information_man.setTextColor(Color.parseColor("#0000ff"));
                perfect_information_women.setTextColor(Color.parseColor("#000000"));
                sex = "男";
                break;
            case R.id.perfect_information_women:
                perfect_information_man.setTextColor(Color.parseColor("#000000"));
                perfect_information_women.setTextColor(Color.parseColor("#0000ff"));
                sex = "女";
                break;
            case R.id.perfect_information_finish:
                SharedPreferences user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = user.edit();
                edit.putString(Constant.User_name, perfect_information_name.getText().toString().trim());
                edit.putString(Constant.User_sex, sex);
                edit.putString(Constant.User_icon, tempFile.getAbsolutePath());
                edit.putString(Constant.User_pass, perfect_information_password.getText().toString().trim());
                break;

            case R.id.perfect_information_album:
                Intent i = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);
                break;
            case R.id.perfect_information_return:
                IPerFectInforPresenter iPerFectInforPresenter = new IPerFectInforPresenter(this);

                String nikename = perfect_information_name.getText().toString().trim();
                String pas = perfect_information_password.getText().toString().trim();
                Intent intent = getIntent();
                String phone = intent.getStringExtra("phone");
         //       iPerFectInforPresenter.loadIperFectMsg(nikename,sex,,phone,pas);
                finish();
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            uri_xiangCe = data.getData();
            caiJianImage();
        }
        if (requestCode == 113 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap photo = extras.getParcelable("data");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] datas = baos.toByteArray();

            Glide.with(this).load(datas)
                    .asBitmap()
                    .into(new ImageViewTarget<Bitmap>(perfect_information_album) {
                        @Override
                        protected void setResource(Bitmap bitmap) {
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                            drawable.setCircular(true);
                            perfect_information_album.setBackground(drawable);
                        }
                    });

//            perfect_information_album.setImageBitmap(photo);
        }
        switch (requestCode) {
            case PHOTO_REQUEST_GALLERY:
                if (data != null)
                    startPhotoZoom(data.getData());
                break;
            case PHOTO_REQUEST_CUT:
                if (data != null)
                    sentPicToNext(data);
                break;
        }
    }

    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    public void sentPicToNext(Intent picdata) {
        Bundle bundle = picdata.getExtras();
        if (bundle != null) {
            Bitmap photo = bundle.getParcelable("data");
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bao);
            byte[] datas = bao.toByteArray();
            if (photo == null) {
                perfect_information_album.setImageResource(R.mipmap.ic_launcher);
            } else {
                Glide.with(this).load(datas)
                        .asBitmap()
                        .into(new ImageViewTarget<Bitmap>(perfect_information_album) {
                            @Override
                            protected void setResource(Bitmap bitmap) {
                                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                                drawable.setCircular(true);
                                perfect_information_album.setBackground(drawable);
                            }
                        });
//                perfect_information_album.setImageBitmap(photo);
            }
            ByteArrayOutputStream baos = null;
            try {
                baos = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] photodata = baos.toByteArray();
                System.out.println(photodata.toString());
            } catch (Exception e) {
                e.getStackTrace();
            } finally {
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void caiJianImage() {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri_xiangCe, "image/*");
        String[] u = uri_xiangCe.toString().split("/");
        imageId_xiangCe = u[u.length - 1].toString();
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 113);
    }

    @Override
    public void showIperFect(PerFectInforBean responseBody) {

    }
}
