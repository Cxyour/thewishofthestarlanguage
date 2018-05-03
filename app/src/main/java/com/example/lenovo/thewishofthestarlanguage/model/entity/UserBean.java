package com.example.lenovo.thewishofthestarlanguage.model.entity;

/**
 * Created by Lenovo on 2018/5/3.
 */

public class UserBean {

    /**
     * code : 1
     * message : cid为空
     * data : {"nickname":"大爷","mobile":"17639267987","photo":"http://qiniu.5roo.com/0fc0a3c2ba6b4acba71db03a9f443f1f.jpg","id":664,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiI2Y3JwM20iLCJzdWIiOiI2NjQiLCJleHAiOjE1MjU5NTMyNjgsImlhdCI6MTUyNTM0ODQ2OH0.q_GVSAKBnaowZrfQyIGnBPTGesyMmpu7P82v9gWexzqcJKzb6ZljKNUcZlt4pFomIlesrd1QCpSWKH1sEyNSWw"}
     */

    private int code;
    private String message;
    /**
     * nickname : 大爷
     * mobile : 17639267987
     * photo : http://qiniu.5roo.com/0fc0a3c2ba6b4acba71db03a9f443f1f.jpg
     * id : 664
     * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiI2Y3JwM20iLCJzdWIiOiI2NjQiLCJleHAiOjE1MjU5NTMyNjgsImlhdCI6MTUyNTM0ODQ2OH0.q_GVSAKBnaowZrfQyIGnBPTGesyMmpu7P82v9gWexzqcJKzb6ZljKNUcZlt4pFomIlesrd1QCpSWKH1sEyNSWw
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
