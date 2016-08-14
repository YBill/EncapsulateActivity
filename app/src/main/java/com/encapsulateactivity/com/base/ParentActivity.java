package com.encapsulateactivity.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.encapsulateactivity.R;

/**
 * BaseActivity
 * Created by Bill on 2016/8/14.
 * <p/>
 * // 参考 http://www.zhihu.com/question/47045239?sort=created
 */
public abstract class ParentActivity extends AppCompatActivity implements View.OnClickListener {

    protected boolean isDebug = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        setListener();
        initData();
    }

    // 通用title
    protected void $setToolBar() {
        Toolbar toolbar = $findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Log
    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(this.getClass().getName(), msg);
        }
    }

    // Toast
    protected void $toast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    // startActivity
    protected void $startActivity(Class<?> cls) {
        $startActivity(cls, null);
    }

    // startActivity
    protected void $startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    // getIntent
    protected Bundle $getIntentExtra() {
        Intent intent = getIntent();
        Bundle bundle = null;
        if (null != intent)
            bundle = intent.getExtras();
        return bundle;
    }

    // findViewById
    public <T extends View> T $findViewById(int resId) {
        return (T) findViewById(resId);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void setListener();

    protected abstract void initData();

    public abstract void widgetClick(View v);

    private long lastClick = 0;

    private boolean fastClick() {
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }


}
