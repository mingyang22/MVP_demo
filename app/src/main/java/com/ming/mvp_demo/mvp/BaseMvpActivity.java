package com.ming.mvp_demo.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ming.mvp_demo.mvp.presenter.BasePresenter;
import com.ming.mvp_demo.mvp.view.IView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author yangming on 2018/12/25
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements IView {
    protected P mPresenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        // 初始化Presenter
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = createPresenter();
        // 完成Presenter和view的绑定
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 将Presenter和view解绑
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        // 解绑ButterKnife
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void showLoading() {
        // 这里实现自己的加载弹框
    }

    @Override
    public void dismissLoading() {
        // 取消弹框
    }

    @Override
    public void onFail(Throwable ex, String code, String msg) {
        // 基础的网络请求失败处理
        dismissLoading();
    }

    @Override
    public void onNetError() {
        // 网络错误处理
        dismissLoading();
    }

    /**
     * 页面初始化数据
     */
    protected void initData() {

    }

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();

    /**
     * 获取当前activity的id
     *
     * @return 当前xml的布局res ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化view控件
     */
    protected abstract void initView();

}

