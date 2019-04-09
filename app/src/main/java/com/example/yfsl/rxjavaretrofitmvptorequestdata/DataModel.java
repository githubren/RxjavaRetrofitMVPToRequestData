package com.example.yfsl.rxjavaretrofitmvptorequestdata;

public class DataModel {

    /**
     * msg : 登陆成功
     * code : 1
     * data : {"Token":"0b070330-ac3c-477e-8f4b-e4a61bfb95ea","UserName":"林丹","UserID":418,"RoleName":"测试","RoleID":22,"RoleApp":[{"Name":"登录权限"},{"Name":"部门权限"}],"DepName":"测试2部","DepID":160,"USER_IMG":"http://172.25.10.195:8080/file/User_Head/Head418.jpg","USER_IMG_APP":"http://222.209.86.146:3312/file/User_Head/Head418.jpg"}
     * num : 1
     */
    private String msg;
    private int code;
    private String data;
    private int num;

    public DataModel(String msg, int code, String data, int num) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.num = num;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data='" + data + '\'' +
                ", num=" + num +
                '}';
    }
}
