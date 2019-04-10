package com.example.yfsl.rxjavaretrofitmvptorequestdata;

/**
 * 面向view的接口 继承PresenterView 定义一个请求成功的方法
 */
public interface DataModelPv extends PresenterView{
    /**
     * 请求成功的方法 实现类中重写这个方法 进行具体的操作
     * @param dataModel
     */
    void onSuccess(DataModel dataModel);
}
