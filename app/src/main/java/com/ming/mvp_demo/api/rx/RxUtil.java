package com.ming.mvp_demo.api.rx;

import com.ming.mvp_demo.api.HttpConstants;
import com.ming.mvp_demo.api.bean.BaseResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author yangming on 2019/1/9
 */
public class RxUtil {
    /**
     * 统一线程处理
     *
     * @param <T> 统一线程处理
     * @return Observable.Transformer
     */
    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一返回结果处理
     *
     * @param <T> 指定的泛型类型
     * @return Observable.Transformer
     */
    public static <T> Observable.Transformer<BaseResponse<T>, T> handleResult() {
        return baseResponseObservable -> baseResponseObservable.flatMap((Func1<BaseResponse<T>, Observable<T>>) baseResponse -> {
            if (baseResponse.getCode().equals(HttpConstants.CODE_REQUEST_SUCCESS)
                    && baseResponse.getData() != null) {
                return createObservable(baseResponse.getData());
            } else {
                return Observable.error(new OtherException(baseResponse.code, baseResponse.desc));
            }

        });
    }

    /**
     * 得到 Observable
     *
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    private static <T> Observable<T> createObservable(final T t) {
        return Observable.unsafeCreate(subscriber -> {
            try {
                subscriber.onNext(t);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }

}
