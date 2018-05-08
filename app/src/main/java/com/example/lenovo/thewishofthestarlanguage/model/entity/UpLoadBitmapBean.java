package com.example.lenovo.thewishofthestarlanguage.model.entity;

/**
 * Created by Lenovo on 2018/5/8.
 */

public class UpLoadBitmapBean {

    /**
     * code : 0
     * message : 成功
     * data : {"fileName":"http://qiniu.5roo.com/f5f0d80e-738a-49c6-bb47-5016d10d4bba.png"}
     */

    private int code;
    private String message;
    /**
     * fileName : http://qiniu.5roo.com/f5f0d80e-738a-49c6-bb47-5016d10d4bba.png
     */

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
        private String fileName;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }
}
