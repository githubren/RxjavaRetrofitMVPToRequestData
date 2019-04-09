package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataModelPresenterModel extends BasePresenterModelImp {
    private Context mContext;
    private DataModelPv mDataModelPv;
    private DataModel mDataModel;

    public DataModelPresenterModel(Context mContext) {
        this.mContext = mContext;
    }

    public void bindPresenterView(PresenterView presenterView){
        mDataModelPv = (DataModelPv) presenterView;
    }

    @SuppressLint("CheckResult")
    public void postData(String url, Map<String,String> map){
        DataManager dataManager = new DataManager(mContext);
        dataManager.postData(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataModel dataModel) {
                        mDataModel = dataModel;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e("TAG","RESULT:"+e);
                        mDataModelPv.onError("请求失败！！！");
                    }

                    @Override
                    public void onComplete() {
                        if (mDataModel!=null){
                            mDataModelPv.onSuccess(mDataModel);
                        }
                    }
                });
    }
}
