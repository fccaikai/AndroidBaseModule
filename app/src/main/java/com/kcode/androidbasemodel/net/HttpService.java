package com.kcode.androidbasemodel.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by caik on 2017/2/27.
 */

public class HttpService {
    private static Retrofit sRetrofit;
    private static HttpService sHttpService;

    public HttpService() {
        sRetrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HttpService get(){
        if (sRetrofit == null) {
            synchronized (HttpService.class) {
                if (sRetrofit == null) {
                    sHttpService = new HttpService();
                }
            }
        }

        return sHttpService;
    }

    public Api create() {
       return sRetrofit.create(Api.class);
    }
}
