package com.ming.mvp_demo.mvp.model;

import com.ming.mvp_demo.api.IApiService;
import com.ming.mvp_demo.api.RetrofitHelper;
import com.ming.mvp_demo.mvp.AppConstants;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author yangming on 2018/12/28
 */
public class BaseModel implements IModel {
    protected IApiService mApi;
    private CompositeSubscription mCompositeSubscription;

    public BaseModel() {
        this.mApi = RetrofitHelper.getInstance().createApiService(AppConstants.BASE_SERVER_IP);
    }

    @Override
    public void unSubscribe() {
        if (mCompositeSubscription != null && !mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.clear();
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }
}
