package com.ming.mvp_demo.api.interfaces;

/**
 * @author yangming on 2018/12/29
 * 网络请求回调
 */
public interface CallBackListener<T> {
    void onSuccess(T data);

    void onFailed(Throwable ex, String code, String msg);

    void onError();
}
