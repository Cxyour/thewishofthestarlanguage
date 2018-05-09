package com.example.lenovo.thewishofthestarlanguage.model.entity;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public class PerFectInforBean {

    /**
     * code : 0
     * message : 成功
     * data : {"nickname":"6202230","mobile":null,"photo":null,"id":888,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJrem5jZXgiLCJzdWIiOiI4ODgiLCJleHAiOjE1MjYyODM0NzksImlhdCI6MTUyNTY3ODY3OX0.yVg9XbRiEWfkG72IDTY-9517s6PYuF6Drhrlv1U8o66rj6Zh2v48TAwfEk-494c1Pd1OD6ic3A8YLitB6RQMxg"}
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
        /**
         * nickname : 6202230
         * mobile : null
         * photo : null
         * id : 888
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJrem5jZXgiLCJzdWIiOiI4ODgiLCJleHAiOjE1MjYyODM0NzksImlhdCI6MTUyNTY3ODY3OX0.yVg9XbRiEWfkG72IDTY-9517s6PYuF6Drhrlv1U8o66rj6Zh2v48TAwfEk-494c1Pd1OD6ic3A8YLitB6RQMxg
         */

        private String nickname;
        private String mobile;
        private String photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
