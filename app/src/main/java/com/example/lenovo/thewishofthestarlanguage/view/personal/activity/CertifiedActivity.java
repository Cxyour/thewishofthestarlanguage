package com.example.lenovo.thewishofthestarlanguage.view.personal.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CertifiedActivity extends BaseActivity implements View.OnClickListener {

    private ImageView certified_return;
    private EditText certified_name;
    private EditText certified_work;
    private EditText certified_personal;
    private RelativeLayout certified_img;
    private ImageView certified_certified_img;
    private Button certified_commit;
    private String imageId_xiangCe;
    private Uri uri_xiangCe;
    private File image_file;
    private static final int PHOTO_REQUEST_GALLERY = 2;
    private static final int PHOTO_REQUEST_CUT = 3;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_certified;
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void init() {
        certified_return = (ImageView) findViewById(R.id.certified_return);
        certified_name = (EditText) findViewById(R.id.certified_name);
        certified_work = (EditText) findViewById(R.id.certified_work);
        certified_personal = (EditText) findViewById(R.id.certified_personal);
        certified_img = (RelativeLayout) findViewById(R.id.certified_img);
        certified_commit = findViewById(R.id.certified_commit);
        certified_certified_img = findViewById(R.id.certified_certified_img);

        certified_return.setOnClickListener(this);
        certified_img.setOnClickListener(this);
        certified_commit.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.certified_return:
                finish();
                break;
            case R.id.certified_img:
                certified_certified_img.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
                break;
            case R.id.certified_commit:

                break;
        }
    }

    // 使用系统当前日期加以调整作为照片的名称
    private File getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
//        MediaType.parse("multipart/form-data"), image_file
        return new File(Environment.getExternalStorageDirectory() + File.separator + dateFormat.format(date) + ".jpg");
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
            System.out.println("Make Picture success,Please find image in " + "D://Android//ShiXun//a.jpg");
            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), photo);
            certified_certified_img.setBackground(drawable);
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
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", 160);
        intent.putExtra("outputY", 160);
        intent.putExtra("return-data", true);
        image_file = getPhotoFileName();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image_file));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
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
            try {
                File file = new File("D://Android//ShiXun//a.jpg");
                FileOutputStream imageOutput = new FileOutputStream(file);
                imageOutput.write(datas, 0, datas.length);
                imageOutput.close();
                System.out.println("Make Picture success,Please find image in " + "D://Android//ShiXun//a.jpg");
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
                ex.printStackTrace();
            }
            if (photo == null) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), photo);
                certified_certified_img.setBackground(drawable);
            } else {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), photo);
                certified_certified_img.setBackground(drawable);
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

}
