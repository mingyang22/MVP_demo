package com.ming.mvp_demo.api.interceptor;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author yangming on 2018/7/19
 * OKHttpClient请求头
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        final Request.Builder builder = chain.request().newBuilder();
        // TODO
//        String accessToken = GlobleSettingData.getInstance().getAuthInfo().getAccessToken();
//        if (!TextUtils.isEmpty(accessToken)) {
//            builder.addHeader("x-ac-token-ticket", accessToken);
//        }
        return chain.proceed(builder.build());
    }
}
