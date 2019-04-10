package com.example.yfsl.rxjavaretrofitmvptorequestdata;

/**
 * 面向view层的接口
 */
public interface PresenterView {
    /**
     * 请求失败的时候  定义一个方法 该接口的实现类重写这个方法 对请求失败时进行具体的操作
     * @param message
     */
    void onError(String message);
}
