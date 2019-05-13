package com.example.yfsl.rxjavaretrofitmvptorequestdata;

public class ResultBean<T> {
    private int code;
    private T data;
    private String msg;
    private int num;

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", num=" + num +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
