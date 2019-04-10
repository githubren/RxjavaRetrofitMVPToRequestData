package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import android.content.Context;

import java.util.Map;

import io.reactivex.Observable;

/**
 * 创建网络请求接口对象 ->重写接口中请求数据的方法
 * 在Activity中直接创建这个类的对象 然后调用其中的方法实现网络请求
 * Activity和Retrofit就不用直接打交道了
 */
public class DataManager {
    private ApiService mApiService;
    private static DataManager instance = null;

    /**
     * 创建接口类型对象
     * @param context
     */
    public DataManager(Context context) {
        mApiService = RetrofitHelper.getInstance(context).getServer();
    }

    /**
     * 懒汉式单例模式创建对象
     * @param context
     * @return
     */
    public static DataManager getInstance(Context context){
        synchronized (DataManager.class){
            if (instance == null){
                instance = new DataManager(context);
            }
        }
        return instance;
    }

    /**
     * 请求数据
     * 用创建的对象调用接口中的方法
     * @param url
     * @param map
     * @return
     */
    public Observable<DataModel> postData(String url, Map<String,String> map){
        return mApiService.postData(url, map);
    }
}
