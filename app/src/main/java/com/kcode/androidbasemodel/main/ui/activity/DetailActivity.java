package com.kcode.androidbasemodel.main.ui.activity;

import com.kcode.androidbasemodel.R;
import com.kcode.baselib.base.BaseActivity;

public class DetailActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void configToolbar() {
        setUpToolbar(R.id.toolbar,"详情",true);
    }

    @Override
    protected void initData() {

    }
}
