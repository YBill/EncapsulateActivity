package com.encapsulateactivity.com.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by 卫彪 on 2016/8/12.
 */
public abstract class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Bill", "ParentActivity onCreate");
        initView();
        setListener();
    }

    protected abstract void initView();

    protected abstract void setListener();

}
