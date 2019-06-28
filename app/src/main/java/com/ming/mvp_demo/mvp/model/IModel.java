package com.ming.mvp_demo.mvp.model;

import rx.Subscription;

/**
 * @author yangming on 2018/12/25
 */
public interface IModel {
    void unSubscribe();

    void addSubscribe(Subscription subscription);
}
