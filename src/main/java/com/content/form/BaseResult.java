package com.content.form;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/10.
 */
public class BaseResult implements Serializable{
    public static final int CODE_SUCCESS=1;
    public static final int CODE_FAIL= -1;

    public BaseResult(){}
    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code;
    public String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
