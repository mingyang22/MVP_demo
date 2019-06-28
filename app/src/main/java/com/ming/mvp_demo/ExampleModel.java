package com.ming.mvp_demo;

import com.ming.mvp_demo.api.rx.RxUtil;
import com.ming.mvp_demo.mvp.model.BaseModel;

import java.util.Map;

import rx.Subscriber;
import rx.Subscription;

/**
 * @author yangming on 2019/3/28
 */
public class ExampleModel extends BaseModel implements ExampleContract.Model {
    @Override
    public void login(Map map, Subscriber subscriber) {
        Subscription subscription = mApi.login(map).compose(RxUtil.applySchedulers()).compose(RxUtil.handleResult()).subscribe(subscriber);
        addSubscribe(subscription);
    }
}
