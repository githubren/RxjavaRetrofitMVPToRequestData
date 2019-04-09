package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit辅助类 用于网络请求
 */
public class RetrofitHelper {
    private static String TAG = "RetrofitHelper";
    private long CONNECT_TIMEOUT = 60L;
    private long READ_TIMEOUT = 30L;
    private long WRITE_TIMEOUT = 30L;
    private static RetrofitHelper mInstance = null;
    private Retrofit mRetrofit = null;

    /**
     * 懒汉式单例模式
     * @return 返回一个对象
     */
    public static RetrofitHelper getInstance(Context context){
        synchronized (RetrofitHelper.class){
            if (mInstance == null){
                mInstance = new RetrofitHelper();
            }
        }
        return mInstance;
    }

    /**
     * 辅助类构造方法 对Retrofit进行初始化
     */
    private RetrofitHelper(){
        initRetrofit();
    }

    /**
     * 初始化
     * 创建Retrofit对象并完成相关配置
     */
    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                //自定义OkHttp
                .client(getOkHttpClient())
                //请求路径
                .baseUrl(Constant.BASE_URL)
                //添加Gson转换器 对服务器进行解析
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 自定义OkHttp  在其中对网络请求进行配置
     * @return 返回一个OkHttpClient对象
     */
    private OkHttpClient getOkHttpClient() {
        //日志拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        /*
            只在开发环境中输出日志
            在开发过程中 为调试版本启用日志  并且让生产版本的日志记录禁用
            采用由Android框架提供的BuildConfig.DEBUG布尔变量
            当是开发环境时返回true 是生产环境时返回false。
         */
        if (BuildConfig.DEBUG)
            //开发环境中 设置日志输出级别为BODY (输出请求和响应的头信息(headers)和内容(body))
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        else
            //生产环境中 设置日志输出级别为BASIC (日志会输出请求类型(request type),请求地址(url),
            // 请求大小(size of request body),响应码(response status)响应大小(size of response body))
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)//连接失败重试
                .connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)//连接超时
                .readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)//读超时
                .writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS)//写超时
                .addInterceptor(new RequestInterceptor())//添加请求拦截器
                .addInterceptor(logging)//添加日志拦截器
                .build();
        return okHttpClient;
    }

    public ApiService getServer(){
        return mRetrofit.create(ApiService.class);
    }
}
