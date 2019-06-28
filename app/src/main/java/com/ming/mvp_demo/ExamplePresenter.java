package com.ming.mvp_demo;

import com.ming.mvp_demo.api.bean.Test;
import com.ming.mvp_demo.api.rx.BaseSubscriber;
import com.ming.mvp_demo.mvp.presenter.BasePresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangming on 2019/3/28
 */
public class ExamplePresenter extends BasePresenter<ExampleContract.View, ExampleContract.Model> implements ExampleContract.Presenter {

    @Override
    protected ExampleModel createModule() {
        return new ExampleModel();
    }

    @Override
    public void login(String phone, String password) {

        showLoading();
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);

        mModel.login(params, new BaseSubscriber<Test>() {

            @Override
            public void onSuccess(Test data) {
                dismissLoading();
                if (isViewAttach()) {
                    getView().onExampleSuccess(data);
                }
            }

            @Override
            public void onFailed(Throwable ex, String code, String msg) {
                onFail(ex, code, msg);
            }

            @Override
            public void onError() {
                onNetError();
            }
        });
    }


}
