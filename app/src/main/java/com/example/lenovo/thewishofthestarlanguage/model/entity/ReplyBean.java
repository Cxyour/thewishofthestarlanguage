package com.example.lenovo.thewishofthestarlanguage.model.entity;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public class ReplyBean {

    /**
     * code : 0
     * message : 成功
     * data : {"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","praiseNum":0,"userId":664,"content":"11111","realname":null,"replyName":null,"nickname":"大爷","replyId":null,"replyNum":0,"isPraise":0,"id":443,"userType":1,"createDate":1525950804000}
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
         * photo : http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg
         * praiseNum : 0
         * userId : 664
         * content : 11111
         * realname : null
         * replyName : null
         * nickname : 大爷
         * replyId : null
         * replyNum : 0
         * isPraise : 0
         * id : 443
         * userType : 1
         * createDate : 1525950804000
         */

        private String photo;
        private int praiseNum;
        private int userId;
        private String content;
        private Object realname;
        private Object replyName;
        private String nickname;
        private Object replyId;
        private int replyNum;
        private int isPraise;
        private int id;
        private int userType;
        private long createDate;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getRealname() {
            return realname;
        }

        public void setRealname(Object realname) {
            this.realname = realname;
        }

        public Object getReplyName() {
            return replyName;
        }

        public void setReplyName(Object replyName) {
            this.replyName = replyName;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getReplyId() {
            return replyId;
        }

        public void setReplyId(Object replyId) {
            this.replyId = replyId;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public int getIsPraise() {
            return isPraise;
        }

        public void setIsPraise(int isPraise) {
            this.isPraise = isPraise;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }
    }
}
