package com.ming.mvp_demo.api.bean;

import java.io.Serializable;

/**
 * @author yangming on 2018/11/12
 */
public class BaseResponse<D> implements Serializable{

    public String code = "";
    public String msg = "";
    public String desc = "";
    public D data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }
}
