package com.encapsulateactivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.encapsulateactivity.com.base.ParentActivity;

public class LoginActivity extends ParentActivity {

    private Button loginBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void $setToolBar() {
        // 不用父类的样式
//        super.$setToolBar();

        // 覆盖父类的样式
        Toolbar toolbar = $findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initView() {
        $setToolBar();

        loginBtn = $findViewById(R.id.button);
    }

    @Override
    protected void setListener() {
        loginBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void widgetClick(View v) {
        if(v == loginBtn){
            Bundle bundle = new Bundle();
            bundle.putString("loginKey", "logValue");
            $startActivity(MainActivity.class, bundle);
        }
    }
}
