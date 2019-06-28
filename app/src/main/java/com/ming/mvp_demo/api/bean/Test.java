package com.ming.mvp_demo.api.bean;

/**
 * @author yangming on 2019/3/28
 */
public class Test {
    private String name;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
