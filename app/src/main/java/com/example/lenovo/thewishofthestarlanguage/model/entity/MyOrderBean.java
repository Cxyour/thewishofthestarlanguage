package com.example.lenovo.thewishofthestarlanguage.model.entity;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/8.
 */

public class MyOrderBean {


    /**
     * code : 0
     * message : 成功
     * data : {"pageNum":1,"pageSize":20,"size":2,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"orderNo":"180509100714037","coverImg":"http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg","price":1730,"orderStatus":0,"oid":1509,"refId":61,"title":"4天，32课时，轻松拿音基教师资格证","type":"体验","startDate":1521855000000},{"orderNo":"180507155144049","coverImg":"http://qiniu.5roo.com/0e9fca4e-def4-493d-85a5-8b391e8b25b7.jpg","price":128,"orderStatus":2,"oid":1460,"refId":66,"title":"艺术沙龙：把你的小梦想，带到更大的艺术世界","type":"体验","startDate":1523685600000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
     */

    private int code;
    private String message;
    /**
     * pageNum : 1
     * pageSize : 20
     * size : 2
     * startRow : 1
     * endRow : 2
     * total : 2
     * pages : 1
     * list : [{"orderNo":"180509100714037","coverImg":"http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg","price":1730,"orderStatus":0,"oid":1509,"refId":61,"title":"4天，32课时，轻松拿音基教师资格证","type":"体验","startDate":1521855000000},{"orderNo":"180507155144049","coverImg":"http://qiniu.5roo.com/0e9fca4e-def4-493d-85a5-8b391e8b25b7.jpg","price":128,"orderStatus":2,"oid":1460,"refId":66,"title":"艺术沙龙：把你的小梦想，带到更大的艺术世界","type":"体验","startDate":1523685600000}]
     * prePage : 0
     * nextPage : 0
     * isFirstPage : true
     * isLastPage : true
     * hasPreviousPage : false
     * hasNextPage : false
     * navigatePages : 8
     * navigatepageNums : [1]
     * navigateFirstPage : 1
     * navigateLastPage : 1
     * firstPage : 1
     * lastPage : 1
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
        /**
         * orderNo : 180509100714037
         * coverImg : http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg
         * price : 1730
         * orderStatus : 0
         * oid : 1509
         * refId : 61
         * title : 4天，32课时，轻松拿音基教师资格证
         * type : 体验
         * startDate : 1521855000000
         */

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
            private String orderNo;
            private String coverImg;
            private int price;
            private int orderStatus;
            private int oid;
            private int refId;
            private String title;
            private String type;
            private long startDate;

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(int orderStatus) {
                this.orderStatus = orderStatus;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public int getRefId() {
                return refId;
            }

            public void setRefId(int refId) {
                this.refId = refId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public long getStartDate() {
                return startDate;
            }

            public void setStartDate(long startDate) {
                this.startDate = startDate;
            }
        }
    }
}
