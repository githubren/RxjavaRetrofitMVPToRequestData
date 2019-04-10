package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 该类继承自接口实现基类
 * 绑定该类和业务对应的PresenterView
 * 重写请求数据的方法
 */
public class DataModelPresenterModel extends BasePresenterModelImp {
    private Context mContext;
    private DataModelPv mDataModelPv;
    private DataModel mDataModel;

    public DataModelPresenterModel(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 绑定view层 在view层中只进行对界面展示的处理
     * @param presenterView
     */
    public void bindPresenterView(PresenterView presenterView){
        mDataModelPv = (DataModelPv) presenterView;
    }

    /**
     * 重写接口中请求数据的方法 因为是加入DataManager这个类进行请求数据postData使得不直接与Retrofit接口交互 所以创建DataManager对象
     * 不同的请求方式做不同的处理将在继承自接口实现基类的这些类中进行
     * 比如此次post请求中需要传送给服务器一组键值对数据  在此进行处理  使得activity调用这个方法的时候得到代码简化
     * @param url 请求地址
     * @param account key
     * @param password value
     */
    public void postData(String url,String account,String password){
        //在此处处理map 使得activity中调用时直接传入参数 简化activity中的代码
        Map<String,String> map = new HashMap<>();
        map.put("USER_PHONE1",account);
        map.put("USER_PSW",password);
        //创建DataManager对象 进行postData
        DataManager dataManager = DataManager.getInstance(mContext);
        dataManager.postData(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //Rxjava中的被观察者订阅观察者
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
