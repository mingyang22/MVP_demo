package com.ming.mvp_demo;

import com.ming.mvp_demo.api.bean.Test;
import com.ming.mvp_demo.mvp.model.IModel;
import com.ming.mvp_demo.mvp.view.IView;

import java.util.Map;

import rx.Subscriber;


/**
 * @author yangming on 2019/3/28
 */
public class ExampleContract {
    interface View extends IView {
        /**
         * 成功
         */
        void onExampleSuccess(Test data);
        /**
         * 失败
         */
        void onExampleFail(Throwable ex, String code, String msg);
    }

    interface Presenter {
        void login(String phone, String password);
    }

    interface Model extends IModel {
        /**
         * 测试
         */
        void login(Map map, Subscriber subscriber);

    }
}
