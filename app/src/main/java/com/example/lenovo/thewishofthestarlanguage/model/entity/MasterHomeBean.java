package com.example.lenovo.thewishofthestarlanguage.model.entity;

import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/9.
 */

public class MasterHomeBean {

    /**
     * code : 0
     * message : 成功
     * data : {"isAttention":0,"courses":[],"liveCourses":[],"liveCount":1,"postsCount":0,"price":0.1,"coachingCount":0,"attentionCount":0,"fansCount":17,"homewokPublishCount":0,"user":{"id":115,"page":1,"rows":20,"pid":0,"salt":"6036153934946050","nickname":"温雪竹","realname":"温雪竹","photo":"http://qiniu.5roo.com/1ec02410-691b-4e60-bd4c-e0c85f080ff8.png","images":"http://qiniu.5roo.com/62697bdb-b5fe-44a7-bb91-d0f56d3685cb.jpg","intro":"表演教师","details":"<p>从事表演教育工作14年。&nbsp;<\/p><p>北京电影学院继续教育学院表演教师。<\/p><p>赵宝刚导演工作室表演培训中心表演教师。<\/p><p>中央电视台大风车栏目表演培训中心表演教师。&nbsp;<\/p><p>中国电影电视艺术学校表演教师。 &nbsp;<\/p><p>天娱传媒（青春计划）表演教师。<\/p><p>北京数字电影学院表演教师。<\/p><p><br><\/p>","mobile":"15321531185","psw":"e6f40e930268e12b5783a198e37745d92a44c6dc0d852701","email":"","sex":1,"birthday":1512489600000,"country":"中国","province":null,"city":"北京","area":null,"address":null,"userType":3,"post":null,"college":"4","major":"6","skilled":"表演,台词,表演","ip":null,"lastTime":1525771379000,"createDate":1525771379000,"idcardFront":null,"idcardBack":null,"teachCard":null,"isauth":0,"identityAuthTime":null,"pushHome":1,"sortTime":1525771379000,"openid":null,"unionid":null,"qqUid":null,"sinaUid":"2393037304","status":0,"topTime":51,"videoPath":"","beanAmount":0,"openidMini":null,"openidWx":null,"flag":null,"weight":3},"praise":{"praiseCount":6,"isPraise":0}}
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
         * isAttention : 0
         * courses : []
         * liveCourses : []
         * liveCount : 1
         * postsCount : 0
         * price : 0.1
         * coachingCount : 0
         * attentionCount : 0
         * fansCount : 17
         * homewokPublishCount : 0
         * user : {"id":115,"page":1,"rows":20,"pid":0,"salt":"6036153934946050","nickname":"温雪竹","realname":"温雪竹","photo":"http://qiniu.5roo.com/1ec02410-691b-4e60-bd4c-e0c85f080ff8.png","images":"http://qiniu.5roo.com/62697bdb-b5fe-44a7-bb91-d0f56d3685cb.jpg","intro":"表演教师","details":"<p>从事表演教育工作14年。&nbsp;<\/p><p>北京电影学院继续教育学院表演教师。<\/p><p>赵宝刚导演工作室表演培训中心表演教师。<\/p><p>中央电视台大风车栏目表演培训中心表演教师。&nbsp;<\/p><p>中国电影电视艺术学校表演教师。 &nbsp;<\/p><p>天娱传媒（青春计划）表演教师。<\/p><p>北京数字电影学院表演教师。<\/p><p><br><\/p>","mobile":"15321531185","psw":"e6f40e930268e12b5783a198e37745d92a44c6dc0d852701","email":"","sex":1,"birthday":1512489600000,"country":"中国","province":null,"city":"北京","area":null,"address":null,"userType":3,"post":null,"college":"4","major":"6","skilled":"表演,台词,表演","ip":null,"lastTime":1525771379000,"createDate":1525771379000,"idcardFront":null,"idcardBack":null,"teachCard":null,"isauth":0,"identityAuthTime":null,"pushHome":1,"sortTime":1525771379000,"openid":null,"unionid":null,"qqUid":null,"sinaUid":"2393037304","status":0,"topTime":51,"videoPath":"","beanAmount":0,"openidMini":null,"openidWx":null,"flag":null,"weight":3}
         * praise : {"praiseCount":6,"isPraise":0}
         */

        private int isAttention;
        private int liveCount;
        private int postsCount;
        private double price;
        private int coachingCount;
        private int attentionCount;
        private int fansCount;
        private int homewokPublishCount;
        private UserBean user;
        private PraiseBean praise;
        private List<?> courses;
        private List<?> liveCourses;

        public int getIsAttention() {
            return isAttention;
        }

        public void setIsAttention(int isAttention) {
            this.isAttention = isAttention;
        }

        public int getLiveCount() {
            return liveCount;
        }

        public void setLiveCount(int liveCount) {
            this.liveCount = liveCount;
        }

        public int getPostsCount() {
            return postsCount;
        }

        public void setPostsCount(int postsCount) {
            this.postsCount = postsCount;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getCoachingCount() {
            return coachingCount;
        }

        public void setCoachingCount(int coachingCount) {
            this.coachingCount = coachingCount;
        }

        public int getAttentionCount() {
            return attentionCount;
        }

        public void setAttentionCount(int attentionCount) {
            this.attentionCount = attentionCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getHomewokPublishCount() {
            return homewokPublishCount;
        }

        public void setHomewokPublishCount(int homewokPublishCount) {
            this.homewokPublishCount = homewokPublishCount;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public PraiseBean getPraise() {
            return praise;
        }

        public void setPraise(PraiseBean praise) {
            this.praise = praise;
        }

        public List<?> getCourses() {
            return courses;
        }

        public void setCourses(List<?> courses) {
            this.courses = courses;
        }

        public List<?> getLiveCourses() {
            return liveCourses;
        }

        public void setLiveCourses(List<?> liveCourses) {
            this.liveCourses = liveCourses;
        }

        public static class UserBean {
            /**
             * id : 115
             * page : 1
             * rows : 20
             * pid : 0
             * salt : 6036153934946050
             * nickname : 温雪竹
             * realname : 温雪竹
             * photo : http://qiniu.5roo.com/1ec02410-691b-4e60-bd4c-e0c85f080ff8.png
             * images : http://qiniu.5roo.com/62697bdb-b5fe-44a7-bb91-d0f56d3685cb.jpg
             * intro : 表演教师
             * details : <p>从事表演教育工作14年。&nbsp;</p><p>北京电影学院继续教育学院表演教师。</p><p>赵宝刚导演工作室表演培训中心表演教师。</p><p>中央电视台大风车栏目表演培训中心表演教师。&nbsp;</p><p>中国电影电视艺术学校表演教师。 &nbsp;</p><p>天娱传媒（青春计划）表演教师。</p><p>北京数字电影学院表演教师。</p><p><br></p>
             * mobile : 15321531185
             * psw : e6f40e930268e12b5783a198e37745d92a44c6dc0d852701
             * email :
             * sex : 1
             * birthday : 1512489600000
             * country : 中国
             * province : null
             * city : 北京
             * area : null
             * address : null
             * userType : 3
             * post : null
             * college : 4
             * major : 6
             * skilled : 表演,台词,表演
             * ip : null
             * lastTime : 1525771379000
             * createDate : 1525771379000
             * idcardFront : null
             * idcardBack : null
             * teachCard : null
             * isauth : 0
             * identityAuthTime : null
             * pushHome : 1
             * sortTime : 1525771379000
             * openid : null
             * unionid : null
             * qqUid : null
             * sinaUid : 2393037304
             * status : 0
             * topTime : 51
             * videoPath :
             * beanAmount : 0
             * openidMini : null
             * openidWx : null
             * flag : null
             * weight : 3
             */

            private int id;
            private int page;
            private int rows;
            private int pid;
            private String salt;
            private String nickname;
            private String realname;
            private String photo;
            private String images;
            private String intro;
            private String details;
            private String mobile;
            private String psw;
            private String email;
            private int sex;
            private long birthday;
            private String country;
            private Object province;
            private String city;
            private Object area;
            private Object address;
            private int userType;
            private Object post;
            private String college;
            private String major;
            private String skilled;
            private Object ip;
            private long lastTime;
            private long createDate;
            private Object idcardFront;
            private Object idcardBack;
            private Object teachCard;
            private int isauth;
            private Object identityAuthTime;
            private int pushHome;
            private long sortTime;
            private Object openid;
            private Object unionid;
            private Object qqUid;
            private String sinaUid;
            private int status;
            private int topTime;
            private String videoPath;
            private int beanAmount;
            private Object openidMini;
            private Object openidWx;
            private Object flag;
            private int weight;

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

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPsw() {
                return psw;
            }

            public void setPsw(String psw) {
                this.psw = psw;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public Object getPost() {
                return post;
            }

            public void setPost(Object post) {
                this.post = post;
            }

            public String getCollege() {
                return college;
            }

            public void setCollege(String college) {
                this.college = college;
            }

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public String getSkilled() {
                return skilled;
            }

            public void setSkilled(String skilled) {
                this.skilled = skilled;
            }

            public Object getIp() {
                return ip;
            }

            public void setIp(Object ip) {
                this.ip = ip;
            }

            public long getLastTime() {
                return lastTime;
            }

            public void setLastTime(long lastTime) {
                this.lastTime = lastTime;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public Object getIdcardFront() {
                return idcardFront;
            }

            public void setIdcardFront(Object idcardFront) {
                this.idcardFront = idcardFront;
            }

            public Object getIdcardBack() {
                return idcardBack;
            }

            public void setIdcardBack(Object idcardBack) {
                this.idcardBack = idcardBack;
            }

            public Object getTeachCard() {
                return teachCard;
            }

            public void setTeachCard(Object teachCard) {
                this.teachCard = teachCard;
            }

            public int getIsauth() {
                return isauth;
            }

            public void setIsauth(int isauth) {
                this.isauth = isauth;
            }

            public Object getIdentityAuthTime() {
                return identityAuthTime;
            }

            public void setIdentityAuthTime(Object identityAuthTime) {
                this.identityAuthTime = identityAuthTime;
            }

            public int getPushHome() {
                return pushHome;
            }

            public void setPushHome(int pushHome) {
                this.pushHome = pushHome;
            }

            public long getSortTime() {
                return sortTime;
            }

            public void setSortTime(long sortTime) {
                this.sortTime = sortTime;
            }

            public Object getOpenid() {
                return openid;
            }

            public void setOpenid(Object openid) {
                this.openid = openid;
            }

            public Object getUnionid() {
                return unionid;
            }

            public void setUnionid(Object unionid) {
                this.unionid = unionid;
            }

            public Object getQqUid() {
                return qqUid;
            }

            public void setQqUid(Object qqUid) {
                this.qqUid = qqUid;
            }

            public String getSinaUid() {
                return sinaUid;
            }

            public void setSinaUid(String sinaUid) {
                this.sinaUid = sinaUid;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getTopTime() {
                return topTime;
            }

            public void setTopTime(int topTime) {
                this.topTime = topTime;
            }

            public String getVideoPath() {
                return videoPath;
            }

            public void setVideoPath(String videoPath) {
                this.videoPath = videoPath;
            }

            public int getBeanAmount() {
                return beanAmount;
            }

            public void setBeanAmount(int beanAmount) {
                this.beanAmount = beanAmount;
            }

            public Object getOpenidMini() {
                return openidMini;
            }

            public void setOpenidMini(Object openidMini) {
                this.openidMini = openidMini;
            }

            public Object getOpenidWx() {
                return openidWx;
            }

            public void setOpenidWx(Object openidWx) {
                this.openidWx = openidWx;
            }

            public Object getFlag() {
                return flag;
            }

            public void setFlag(Object flag) {
                this.flag = flag;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }
        }

        public static class PraiseBean {
            /**
             * praiseCount : 6
             * isPraise : 0
             */

            private int praiseCount;
            private int isPraise;

            public int getPraiseCount() {
                return praiseCount;
            }

            public void setPraiseCount(int praiseCount) {
                this.praiseCount = praiseCount;
            }

            public int getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(int isPraise) {
                this.isPraise = isPraise;
            }
        }
    }
}
