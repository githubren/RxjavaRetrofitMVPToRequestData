package com.example.yfsl.rxjavaretrofitmvptorequestdata;

public interface PresenterModel {
    /**
     * 创建Presenter
     */
    void onCreate();
    /**
     * 销毁Presenter
     */
    void onDestroy();
    /**
     * 绑定Presenter和View
     */
    void bindPresenterVIew(PresenterView presenterView);
}
