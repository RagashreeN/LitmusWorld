package com.litmus.interview.common.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.litmus.interview.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    public static NetworkService instance = null;
    private Retrofit retrofit;
    private NetworkAPI networkAPI;

    public NetworkService(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //if(BuildConfig){
            builder.addInterceptor(loggingInterceptor);
        //}
        OkHttpClient client = builder.build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client).build();
        networkAPI = retrofit.create(NetworkAPI.class);
    }

    public static NetworkService getInstance(){
        if(instance==null){
            instance = new NetworkService();
        }
        return instance;
    }

    public NetworkAPI getNetworkAPI() {
        return networkAPI;
    }
}
