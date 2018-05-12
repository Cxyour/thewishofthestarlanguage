package com.example.lenovo.thewishofthestarlanguage.model.entity;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class AboutUnivStarBean {

    /**
     * code : 0
     * message : 成功
     * data : {"id":39,"page":1,"rows":20,"logo":"http://image.5roo.com/uwo-file/fast/data/00/A1/ctcYLloMDAqASZV8AAUXvvtCsVI802.jpg","version":"1.0.1","content":"guanyu "}
     */

    private int code;
    private String message;
    /**
     * id : 39
     * page : 1
     * rows : 20
     * logo : http://image.5roo.com/uwo-file/fast/data/00/A1/ctcYLloMDAqASZV8AAUXvvtCsVI802.jpg
     * version : 1.0.1
     * content : guanyu
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
        private int id;
        private int page;
        private int rows;
        private String logo;
        private String version;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
