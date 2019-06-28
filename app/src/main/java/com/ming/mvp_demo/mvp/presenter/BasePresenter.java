package com.ming.mvp_demo.mvp.presenter;


import com.ming.mvp_demo.mvp.model.IModel;
import com.ming.mvp_demo.mvp.view.IView;

import java.lang.ref.WeakReference;

/**
 * @author yangming on 2018/12/25
 */
public abstract class BasePresenter<T extends IView, K extends IModel> implements IPresenter<T> {
    protected K mModel;
    private WeakReference<T> weakReference;

    @Override
    public void attachView(T view) {
        // 使用弱引用持有view对象，防止内存泄漏
        weakReference = new WeakReference<>(view);
        if (this.mModel == null) {
            this.mModel = createModule();
        }
    }

    @Override
    public void detachView() {
        if (isViewAttach()) {
            weakReference.clear();
            weakReference = null;
        }
        if (mModel != null) {
            mModel.unSubscribe();
            mModel = null;
        }
    }

    @Override
    public boolean isViewAttach() {
        return weakReference != null && weakReference.get() != null;
    }

    protected T getView() {
        return weakReference.get();
    }

    protected void showLoading() {
        if (isViewAttach()) {
            getView().showLoading();
        }
    }

    protected void onFail(Throwable ex, String code, String msg) {
        if (isViewAttach()) {
            getView().onFail(ex, code, msg);
        }
    }

    protected void onNetError() {
        if (isViewAttach()) {
            getView().onNetError();
        }
    }

    protected void dismissLoading() {
        if (isViewAttach()) {
            getView().dismissLoading();
        }
    }

    /**
     * 由外部创建 module
     *
     * @return module
     */
    protected abstract K createModule();

}
