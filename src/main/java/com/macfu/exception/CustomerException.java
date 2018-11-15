package com.macfu.exception;

import java.lang.reflect.Field;

/**
 * @Author: liming
 * @Date: 2018/11/15 15:18
 * @Description: CustomerException
 */
public class CustomerException extends RuntimeException {
    private int code = 0;
    private String msg = "";
    private Object data;

    public CustomerException() {

    }

    public CustomerException(Object any) {
        try {
            deal(any);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CustomerException(Object any, String data) {
        try {
            deal(any);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.data = data;
    }

    public CustomerException(String msg, Object data) {
        this.msg = msg;
        this.data = data;
        this.code = 999;
    }

    public CustomerException(String msg, String data) {
        this.msg = msg;
        this.data = data;
        this.code = 999;
    }

    public CustomerException(String msg) {
        this.msg = msg;
        this.code = 999;
    }

    private void deal(Object any) throws NoSuchFieldException, IllegalAccessException {
        Class<?> java = any.getClass();
        Field value = java.getDeclaredField("value");
        value.setAccessible(true);
        this.code = value.getInt(any);
        Field msg = java.getDeclaredField("msg");
        msg.setAccessible(true);
        this.msg = msg.get(any).toString();
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
