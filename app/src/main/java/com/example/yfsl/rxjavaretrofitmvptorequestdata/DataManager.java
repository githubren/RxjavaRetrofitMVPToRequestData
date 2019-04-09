package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import android.content.Context;

import java.util.Map;

import io.reactivex.Observable;

public class DataManager {
    private ApiService mApiService;
    private static DataManager instance = null;

    public DataManager(Context context) {
        mApiService = RetrofitHelper.getInstance(context).getServer();
    }

    public static DataManager getInstance(Context context){
        synchronized (DataManager.class){
            if (instance == null){
                instance = new DataManager(context);
            }
        }
        return instance;
    }

    public Observable<DataModel> postData(String url, Map<String,String> map){
        return mApiService.postData(url, map);
    }
}
