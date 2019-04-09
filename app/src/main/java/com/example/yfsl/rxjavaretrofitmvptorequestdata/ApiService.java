package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * 网络请求接口
 * POST请求 传送数据到服务器并接收返回的数据
 * Url请求的地址
 * FieldMap 传送数据集合
 */
public interface ApiService {
    @FormUrlEncoded
    @POST
    Observable<DataModel> postData(@Url String url, @FieldMap Map<String,String> map);
}
