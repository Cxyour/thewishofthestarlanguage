package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.model.config.Constant;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyselfMessageActivity extends BaseActivity implements View.OnClickListener {

    private ImageView myself_photo;
    private RelativeLayout myself_photo_set;
    private TextView myself_nickname;
    private RelativeLayout myself_nickname_set;
    private TextView myself_sex;
    private RelativeLayout myself_sex_set;
    private TextView myself_address;
    private RelativeLayout myself_address_set;
    private TextView myself_birthday;
    private RelativeLayout myself_birthday_set;
    private ImageView myself_return;
    private SharedPreferences user;
    private String imageId_xiangCe;
    private Uri uri_xiangCe;
    private static final int PHOTO_REQUEST_GALLERY = 2;
    private static final int PHOTO_REQUEST_CUT = 3;
    private File tempFile = new File(Environment.getExternalStorageDirectory(),
            getPhotoFileName());
    private SharedPreferences.Editor edit;
    private Intent intent;
    private View inflate;
    private TextView dialog_sex_man;
    private TextView dialog_sex_woman;
    private Dialog dialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_myself_message;
    }

    @Override
    protected void init() {
        myself_photo = (ImageView) findViewById(R.id.myself_photo);
        myself_photo_set = (RelativeLayout) findViewById(R.id.myself_photo_set);
        myself_nickname = (TextView) findViewById(R.id.myself_nickname);
        myself_nickname_set = (RelativeLayout) findViewById(R.id.myself_nickname_set);
        myself_sex = (TextView) findViewById(R.id.myself_sex);
        myself_sex_set = (RelativeLayout) findViewById(R.id.myself_sex_set);
        myself_address = (TextView) findViewById(R.id.myself_address);
        myself_address_set = (RelativeLayout) findViewById(R.id.myself_address_set);
        myself_birthday = (TextView) findViewById(R.id.myself_birthday);
        myself_birthday_set = (RelativeLayout) findViewById(R.id.myself_birthday_set);
        inflate = getLayoutInflater().inflate(R.layout.dialog_view, null);
        dialog_sex_man = inflate.findViewById(R.id.dialog_sex_man);
        dialog_sex_woman = inflate.findViewById(R.id.dialog_sex_woman);
        dialog_sex_man.setOnClickListener(this);
        dialog_sex_woman.setOnClickListener(this);
        myself_return = findViewById(R.id.myself_return);
        myself_photo_set.setOnClickListener(this);
        myself_nickname_set.setOnClickListener(this);
        myself_sex_set.setOnClickListener(this);
        myself_address_set.setOnClickListener(this);
        myself_birthday_set.setOnClickListener(this);
        myself_return.setOnClickListener(this);
        dialog = new Dialog(this);
        dialog.setContentView(inflate);
        dialog.setTitle("请选择");

    }

    @Override
    protected void loadData() {
        user = getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        edit = user.edit();
        Glide.with(this).load(user.getString("photo", "")).asBitmap().into(new ImageViewTarget<Bitmap>(myself_photo) {
            @Override
            protected void setResource(Bitmap bitmap) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                drawable.setCircular(true);
                myself_photo.setBackground(drawable);
            }
        });
        myself_nickname.setText(user.getString("nickname", ""));
        if (user.getInt("sex", 0) == 0) {
            myself_sex.setText("男");
        } else {
            myself_sex.setText("女");
        }
        myself_address.setText(user.getString("address", ""));
        myself_birthday.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(user.getLong("birthday", 0))));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myself_photo_set:
                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
                edit.putString("photo", tempFile.getAbsolutePath());
                break;
            case R.id.myself_nickname_set:
                intent = new Intent(this, ChangeNickNameActivity.class);
                intent.putExtra("nickname", myself_nickname.getText());
                startActivityForResult(intent, 1);
                break;
            case R.id.myself_sex_set:
                dialog.show();
                break;
            case R.id.myself_address_set:
                intent = new Intent(this, ChangeAddressActivity.class);
                intent.putExtra("address", myself_address.getText());
                startActivityForResult(intent, 5);
                break;
            case R.id.myself_birthday_set:
                showDatePickDlg(myself_birthday);
                break;
            case R.id.myself_return:
                finish();
                break;

            case R.id.dialog_sex_man:
                myself_sex.setText(dialog_sex_man.getText());
                dialog.dismiss();
                break;
            case R.id.dialog_sex_woman:
                myself_sex.setText(dialog_sex_woman.getText());
                dialog.dismiss();
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            myself_nickname.setText(data.getStringExtra("newNickName"));
        }
        if (requestCode == 5 && resultCode == 4) {
            myself_address.setText(data.getStringExtra("newAddress"));
        }
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
                    .into(new ImageViewTarget<Bitmap>(myself_photo) {
                        @Override
                        protected void setResource(Bitmap bitmap) {
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                            drawable.setCircular(true);
                            myself_photo.setBackground(drawable);
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
                myself_photo.setImageResource(R.mipmap.ic_launcher);
            } else {
                Glide.with(this).load(datas)
                        .asBitmap()
                        .into(new ImageViewTarget<Bitmap>(myself_photo) {
                            @Override
                            protected void setResource(Bitmap bitmap) {
                                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                                drawable.setCircular(true);
                                myself_photo.setBackground(drawable);
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

    // 使用系统当前日期加以调整作为照片的名称
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }

    private void showDatePickDlg(final TextView textView) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                textView.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
}
