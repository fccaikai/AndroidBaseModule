package com.kcode.androidbasemodel.net;

import com.kcode.androidbasemodel.main.model.repository.GanhuoRepository;
import com.kcode.baselib.net.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by caik on 2017/2/24.
 */

public interface Api {
    @GET("/api/data/Android/10/1")
    Call<Response<List<GanhuoRepository>>> getGanhuo();
}
