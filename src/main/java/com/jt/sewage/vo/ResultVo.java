package com.jt.sewage.vo;

import com.jt.sewage.entity.Sewage;

public class ResultVo {
    private int code = 1;
    private String msg;
    private Sewage data;

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
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

    public Sewage getData() {
        return data;
    }

    public void setData(Sewage data) {
        this.data = data;
    }
}
