package com.encapsulateactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.encapsulateactivity.com.base.ParentActivity;

public class MainActivity extends ParentActivity {

    private Button button;
    private TextView titleText;

    private String intentText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void $setToolBar() {
        // 用父类的样式
        super.$setToolBar();
    }

    @Override
    protected void initView() {
        $setToolBar();
        button = $findViewById(R.id.button);
        titleText = $findViewById(R.id.tv_title);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        titleText.setText("标题");
        Bundle bundle = $getIntentExtra();
        if(null != bundle)
            intentText = bundle.getString("loginKey");
        $Log(intentText);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.button:
                $toast("Click:" + intentText);
            break;
        }
    }
}
