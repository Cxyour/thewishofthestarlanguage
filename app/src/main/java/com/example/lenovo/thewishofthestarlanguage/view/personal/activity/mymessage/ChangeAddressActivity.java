package com.example.lenovo.thewishofthestarlanguage.view.personal.activity.mymessage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lenovo.thewishofthestarlanguage.R;
import com.example.lenovo.thewishofthestarlanguage.view.base.BaseActivity;

public class ChangeAddressActivity extends BaseActivity implements View.OnClickListener {

    private ImageView change_address_return;
    private Button change_address_save;
    private EditText change_address_editText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_address;
    }

    @Override
    protected void init() {
        change_address_return = (ImageView) findViewById(R.id.change_address_return);
        change_address_save = (Button) findViewById(R.id.change_address_save);
        change_address_editText = (EditText) findViewById(R.id.change_address_editText);

        change_address_return.setOnClickListener(this);
        change_address_save.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        change_address_editText.setText(getIntent().getStringExtra("address"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_address_save:
                Intent intent = new Intent();
                intent.putExtra("newAddress", change_address_editText.getText().toString().trim());
                setResult(4, intent);
                finish();
                break;
            case R.id.change_address_return:
                finish();
                break;
        }
    }

}
