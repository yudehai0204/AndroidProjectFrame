package com.project.base;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.base
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class BaseBean<T> {
    private int code;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
