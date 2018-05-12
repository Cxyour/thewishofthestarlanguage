package com.example.lenovo.thewishofthestarlanguage.model.entity;

import java.util.List;

/**
 * Created by 陈伟霆 on 2018/5/10.
 */

public class TeacherFenSi {

    /**
     * code : 0
     * message : 成功
     * data : {"pageNum":1,"pageSize":20,"size":20,"startRow":1,"endRow":20,"total":22,"pages":2,"list":[{"fansId":662,"intro":null,"nickname":"旧梦 Toxicant°","photo":"http://qiniu.5roo.com/74dd477313a64905a41814b35ee8c535.jpg","attention":0,"userType":1,"realname":null},{"fansId":873,"intro":null,"nickname":"哈哈哈","photo":null,"attention":0,"userType":1,"realname":null},{"fansId":873,"intro":null,"nickname":"哈哈哈","photo":null,"attention":0,"userType":1,"realname":null},{"fansId":919,"intro":null,"nickname":"\u2026\u2026","photo":"http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg","attention":0,"userType":1,"realname":null},{"fansId":885,"intro":null,"nickname":"Sunny佳乐家","photo":null,"attention":0,"userType":1,"realname":null},{"fansId":224,"intro":null,"nickname":"冰峰","photo":"http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epwO7nM7ShxZoiaYHuvSiaw0YHKTDBsSMYBVVGjAtwibHMB5ShKKJN5EOB1BfnstSibADHqQAicwhok3uQ/132","attention":0,"userType":1,"realname":null},{"fansId":276,"intro":"美术达人","nickname":"张鹏远","photo":"http://qiniu.5roo.com/3dd87e36-ecfe-4049-bb1a-20c65b07f6e5.jpg","attention":0,"userType":2,"realname":"张鹏远"},{"fansId":197,"intro":null,"nickname":"考拉","photo":"http://qiniu.5roo.com/dc4fbce0d3b14ac188e48be8926367de.jpg","attention":0,"userType":1,"realname":null},{"fansId":474,"intro":null,"nickname":"勇往直前","photo":"http://qiniu.5roo.com/267ccbe1-f702-40ad-bd12-9e4fd2f8a593.jpg","attention":0,"userType":1,"realname":"贾明"},{"fansId":600,"intro":null,"nickname":"英子","photo":"http://qiniu.5roo.com/40223b5e95cb4d8aacbe3e532b0d0ee2.jpg","attention":0,"userType":1,"realname":null},{"fansId":256,"intro":"","nickname":"墨千","photo":"http://qiniu.5roo.com/a7403589-54e6-4a25-b0f7-e1190c8f6b8c.png","attention":0,"userType":1,"realname":null},{"fansId":221,"intro":"艺术人生规划","nickname":"葡萄仙女","photo":"http://qiniu.5roo.com/5259e305-c9bd-4f57-8dff-30a5072655bb.jpg","attention":0,"userType":2,"realname":"葡萄仙女"},{"fansId":575,"intro":null,"nickname":"宋勇杰","photo":"http://qiniu.5roo.com/20a70723c3b4461db5156e4e335a569b.jpg","attention":0,"userType":1,"realname":null},{"fansId":200,"intro":null,"nickname":"全家福","photo":"http://qiniu.5roo.com/3a829625-7a79-4e03-b318-92cd9872495a.jpg","attention":0,"userType":1,"realname":null},{"fansId":203,"intro":"","nickname":"韩小胖","photo":"http://qiniu.5roo.com/cc7c215a-48a8-4ef4-a838-a3bbfacfd8d8.jpg","attention":0,"userType":6,"realname":"韩庆鑫"},{"fansId":350,"intro":"编导","nickname":"石磊","photo":"http://qiniu.5roo.com/ee679a62-aeb0-4cbe-9610-f7067ac20681.jpg","attention":0,"userType":2,"realname":"石磊"},{"fansId":337,"intro":null,"nickname":"久","photo":"http://qiniu.5roo.com/a97d456e822a477fbcff067855da9a6f.jpg","attention":0,"userType":1,"realname":null},{"fansId":320,"intro":null,"nickname":"Vicky","photo":"http://thirdwx.qlogo.cn/mmopen/vi_32/rPBic3KQlk1jwnfTiceT95QwgWibCOB6gDE0PtcdTdRBVQvVGicwED4Bt6ZcdrEBJQT7VQaZRI0o2pkfT5S6sJu8Og/132","attention":0,"userType":1,"realname":null},{"fansId":312,"intro":null,"nickname":"chanle","photo":"http://thirdwx.qlogo.cn/mmopen/vi_32/gpO5Uumbh2yV8rIuW1TXicDeB8kCwsLoC1DxNNODWIMibXt7bybgiapTFEVjqSwjyiaNWw6JzJrwpZ6Z4a7KIQrzJQ/132","attention":0,"userType":1,"realname":null},{"fansId":290,"intro":null,"nickname":"青城山下你鹤爸i","photo":"http://qiniu.5roo.com/419efee2-f63f-4ffe-a22e-b3e2beec0bbe.jpg","attention":0,"userType":1,"realname":null}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2,"firstPage":1,"lastPage":2}
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
         * pageNum : 1
         * pageSize : 20
         * size : 20
         * startRow : 1
         * endRow : 20
         * total : 22
         * pages : 2
         * list : [{"fansId":662,"intro":null,"nickname":"旧梦 Toxicant°","photo":"http://qiniu.5roo.com/74dd477313a64905a41814b35ee8c535.jpg","attention":0,"userType":1,"realname":null},{"fansId":873,"intro":null,"nickname":"哈哈哈","photo":null,"attention":0,"userType":1,"realname":null},{"fansId":873,"intro":null,"nickname":"哈哈哈","photo":null,"attention":0,"userType":1,"realname":null},{"fansId":919,"intro":null,"nickname":"\u2026\u2026","photo":"http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg","attention":0,"userType":1,"realname":null},{"fansId":885,"intro":null,"nickname":"Sunny佳乐家","photo":null,"attention":0,"userType":1,"realname":null},{"fansId":224,"intro":null,"nickname":"冰峰","photo":"http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epwO7nM7ShxZoiaYHuvSiaw0YHKTDBsSMYBVVGjAtwibHMB5ShKKJN5EOB1BfnstSibADHqQAicwhok3uQ/132","attention":0,"userType":1,"realname":null},{"fansId":276,"intro":"美术达人","nickname":"张鹏远","photo":"http://qiniu.5roo.com/3dd87e36-ecfe-4049-bb1a-20c65b07f6e5.jpg","attention":0,"userType":2,"realname":"张鹏远"},{"fansId":197,"intro":null,"nickname":"考拉","photo":"http://qiniu.5roo.com/dc4fbce0d3b14ac188e48be8926367de.jpg","attention":0,"userType":1,"realname":null},{"fansId":474,"intro":null,"nickname":"勇往直前","photo":"http://qiniu.5roo.com/267ccbe1-f702-40ad-bd12-9e4fd2f8a593.jpg","attention":0,"userType":1,"realname":"贾明"},{"fansId":600,"intro":null,"nickname":"英子","photo":"http://qiniu.5roo.com/40223b5e95cb4d8aacbe3e532b0d0ee2.jpg","attention":0,"userType":1,"realname":null},{"fansId":256,"intro":"","nickname":"墨千","photo":"http://qiniu.5roo.com/a7403589-54e6-4a25-b0f7-e1190c8f6b8c.png","attention":0,"userType":1,"realname":null},{"fansId":221,"intro":"艺术人生规划","nickname":"葡萄仙女","photo":"http://qiniu.5roo.com/5259e305-c9bd-4f57-8dff-30a5072655bb.jpg","attention":0,"userType":2,"realname":"葡萄仙女"},{"fansId":575,"intro":null,"nickname":"宋勇杰","photo":"http://qiniu.5roo.com/20a70723c3b4461db5156e4e335a569b.jpg","attention":0,"userType":1,"realname":null},{"fansId":200,"intro":null,"nickname":"全家福","photo":"http://qiniu.5roo.com/3a829625-7a79-4e03-b318-92cd9872495a.jpg","attention":0,"userType":1,"realname":null},{"fansId":203,"intro":"","nickname":"韩小胖","photo":"http://qiniu.5roo.com/cc7c215a-48a8-4ef4-a838-a3bbfacfd8d8.jpg","attention":0,"userType":6,"realname":"韩庆鑫"},{"fansId":350,"intro":"编导","nickname":"石磊","photo":"http://qiniu.5roo.com/ee679a62-aeb0-4cbe-9610-f7067ac20681.jpg","attention":0,"userType":2,"realname":"石磊"},{"fansId":337,"intro":null,"nickname":"久","photo":"http://qiniu.5roo.com/a97d456e822a477fbcff067855da9a6f.jpg","attention":0,"userType":1,"realname":null},{"fansId":320,"intro":null,"nickname":"Vicky","photo":"http://thirdwx.qlogo.cn/mmopen/vi_32/rPBic3KQlk1jwnfTiceT95QwgWibCOB6gDE0PtcdTdRBVQvVGicwED4Bt6ZcdrEBJQT7VQaZRI0o2pkfT5S6sJu8Og/132","attention":0,"userType":1,"realname":null},{"fansId":312,"intro":null,"nickname":"chanle","photo":"http://thirdwx.qlogo.cn/mmopen/vi_32/gpO5Uumbh2yV8rIuW1TXicDeB8kCwsLoC1DxNNODWIMibXt7bybgiapTFEVjqSwjyiaNWw6JzJrwpZ6Z4a7KIQrzJQ/132","attention":0,"userType":1,"realname":null},{"fansId":290,"intro":null,"nickname":"青城山下你鹤爸i","photo":"http://qiniu.5roo.com/419efee2-f63f-4ffe-a22e-b3e2beec0bbe.jpg","attention":0,"userType":1,"realname":null}]
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
         * navigateFirstPage : 1
         * navigateLastPage : 2
         * firstPage : 1
         * lastPage : 2
         */

        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private int firstPage;
        private int lastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * fansId : 662
             * intro : null
             * nickname : 旧梦 Toxicant°
             * photo : http://qiniu.5roo.com/74dd477313a64905a41814b35ee8c535.jpg
             * attention : 0
             * userType : 1
             * realname : null
             */

            private int fansId;
            private Object intro;
            private String nickname;
            private String photo;
            private int attention;
            private int userType;
            private Object realname;

            public int getFansId() {
                return fansId;
            }

            public void setFansId(int fansId) {
                this.fansId = fansId;
            }

            public Object getIntro() {
                return intro;
            }

            public void setIntro(Object intro) {
                this.intro = intro;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getAttention() {
                return attention;
            }

            public void setAttention(int attention) {
                this.attention = attention;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public Object getRealname() {
                return realname;
            }

            public void setRealname(Object realname) {
                this.realname = realname;
            }
        }
    }
}
