package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
    @FormUrlEncoded
    @POST
    Observable<DataModel> postData(@Url String url, @FieldMap Map<String,String> map);
}
