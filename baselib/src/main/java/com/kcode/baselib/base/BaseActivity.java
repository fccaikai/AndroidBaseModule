package com.kcode.baselib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.kcode.baselib.R;

/**
 * Created by caik on 2017/2/24.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() <= 0) {
            throw new RuntimeException("must setContentView");
        }

        setContentView(getLayoutId());
        configToolbar();
        bindView();
        initData();
    }

    protected void setUpToolbar(int toolbarId) {
        setUpToolbar(toolbarId,getResources().getString(R.string.app_name));
    }

    protected void setUpToolbar(int toolbarId,String title) {
        setUpToolbar(toolbarId, title,false);
    }

    protected void setUpToolbar(int toolbarId,String title,boolean showUp) {
        Toolbar toolbar = $(toolbarId);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(showUp);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected <V extends View> V $(int resId) {
        return (V) findViewById(resId);
    }

    protected abstract int getLayoutId();

    protected abstract void bindView();

    protected abstract void configToolbar();

    protected abstract void initData();
}
