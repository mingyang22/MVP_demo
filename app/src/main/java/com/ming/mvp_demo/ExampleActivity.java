package com.ming.mvp_demo;

import com.ming.mvp_demo.api.bean.Test;
import com.ming.mvp_demo.mvp.BaseMvpActivity;

/**
 * @author yangming on 2019/3/28
 */
public class ExampleActivity extends BaseMvpActivity<ExamplePresenter> implements ExampleContract.View {
    @Override
    protected ExamplePresenter createPresenter() {
        return new ExamplePresenter();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {
        mPresenter.login("", "");
    }

    @Override
    public void onExampleSuccess(Test data) {

    }

    @Override
    public void onExampleFail(Throwable ex, String code, String msg) {

    }
}
