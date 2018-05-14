package com.example.lenovo.thewishofthestarlanguage.model.entity;

/**
 * Created by 陈伟霆 on 2018/5/14.
 */

public class OrderMsgBean {

    /**
     * code : 0
     * message : 成功
     * data : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017121300703777&biz_content=%7B%22out_trade_no%22%3A%22180514160721041%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%85%85%E5%80%BC%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%221.0%22%7D&charset=UTF-8&format=JSON&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.univstar.com%2Fv1%2Fm%2Falipay%2FnotifyUrl&sign=c5YWgCdtMY1Op%2FyWM58uwYwqvNp1XzcHOkDulxkrepXDjDfefjjs2ni%2FWHNNFJQhUtCQq%2B8rEBdW6vDtkUN2O467V86qU7C0fhP2i63Y8fxVzlEUiTOWCLLCNPQp1IpfkH6pBH8%2FlgJnit%2FBExCyEFORNDWVEc7vlXoYo5XdZ0w0CpnKPLQmf3N7OsmOxCeGzQOeXJ7If6mQVgZ19tupIMrogpodJg%2Bml3TkEZHwOWajKMZdd4bdK2nhH9WEmH5t9p3YpZjuJaOkrLHx6px4VFpFwDlsfApplj1Aqxt2eZYM%2FL8Oasok6ZKYaQKcrHhOsA%2FEAwCASW8Xh5OsPS91Ww%3D%3D&sign_type=RSA2&timestamp=2018-05-14+16%3A08%3A05&version=1.0
     */

    private int code;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
