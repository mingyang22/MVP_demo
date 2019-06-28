package com.ming.mvp_demo.api;

import com.ming.mvp_demo.api.bean.BaseResponse;
import com.ming.mvp_demo.api.bean.Test;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author yangming on 2018/12/29
 */
public interface IApiService {

    /**
     * 测试
     */
    @POST("")
    Observable<BaseResponse<Test>> login(@Body Map params);

}
