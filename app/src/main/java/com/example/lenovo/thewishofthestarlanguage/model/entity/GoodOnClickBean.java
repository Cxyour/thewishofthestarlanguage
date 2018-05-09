package com.example.lenovo.thewishofthestarlanguage.model.entity;

/**
 * Created by 陈伟霆 on 2018/5/8.
 */

public class GoodOnClickBean {

    /**
     * code : 1
     * message : 错误
     * data : {}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
