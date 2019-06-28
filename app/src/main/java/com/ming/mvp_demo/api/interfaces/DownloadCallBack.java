package com.ming.mvp_demo.api.interfaces;

/**
 * @author yangming on 2018/8/6
 * 文件下载回调
 */
public interface DownloadCallBack {
    void onProgress(int progress);

    void onCompleted();

    void onError(String msg);
}
