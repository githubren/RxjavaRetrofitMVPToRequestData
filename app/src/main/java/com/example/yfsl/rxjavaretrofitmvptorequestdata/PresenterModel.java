package com.example.yfsl.rxjavaretrofitmvptorequestdata;

/**
 * 创建一个面向Model层的接口 还有一个面向View层的接口PresenterView
 * 定义3个方法
 */
public interface PresenterModel {
    /**
     * 初始化PresenterModel
     */
    void init();
    /**
     * 销毁PresenterModel
     */
    void onDestroy();
    /**
     * 绑定PresenterModel和PresenterView
     * 实现View和Model的间接交互
     */
    void bindPresenterVIew(PresenterView presenterView);
}
