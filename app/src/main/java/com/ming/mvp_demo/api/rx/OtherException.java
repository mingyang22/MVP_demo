package com.ming.mvp_demo.api.rx;

/**
 * @author yangming on 2019/1/9
 */
public class OtherException extends Exception {
    private String code;
    private String msg;

    public OtherException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
