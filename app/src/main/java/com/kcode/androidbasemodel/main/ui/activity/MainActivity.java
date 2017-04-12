package com.kcode.androidbasemodel.main.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kcode.androidbasemodel.R;
import com.kcode.androidbasemodel.main.model.repository.GanhuoRepository;
import com.kcode.androidbasemodel.net.HttpService;
import com.kcode.baselib.base.BaseActivity;
import com.kcode.baselib.net.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindView() {
        mRecyclerView = $(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void configToolbar() {
        setUpToolbar(R.id.toolbar);
    }

    @Override
    protected void initData() {
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        Call<Response<List<GanhuoRepository>>> call = HttpService.get().create().getGanhuo();
        call.enqueue(new Callback<Response<List<GanhuoRepository>>>() {
            @Override
            public void onResponse(Call<Response<List<GanhuoRepository>>> call, retrofit2.Response<Response<List<GanhuoRepository>>> response) {
                List<GanhuoRepository> results = response.body().getResults();
                for (GanhuoRepository repository : results ) {
                    Log.d(TAG, repository.getDesc());
                }

            }

            @Override
            public void onFailure(Call<Response<List<GanhuoRepository>>> call, Throwable t) {

            }
        });

    }
}
