package com.encapsulateactivity;

import android.os.Bundle;
import android.util.Log;

import com.encapsulateactivity.com.base.ParentActivity;

public class MainActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Bill", "MainActivity onCreate");
    }

    @Override
    protected void initView() {
        Log.v("Bill", "MainActivity initView");
    }

    @Override
    protected void setListener() {
        Log.v("Bill", "MainActivity setListener");
    }
}
