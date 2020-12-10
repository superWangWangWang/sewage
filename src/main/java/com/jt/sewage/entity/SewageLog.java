package com.jt.sewage.entity;

import java.util.Date;

public class SewageLog {
    //id         int(11)
    private Integer id;
    //time       timestamp     时间
    private Date time;
    //log        varchar(128)  日志内容
    private String log;
    //ip         varchar(16)   ip
    private String ip;
    //ip_detail  varchar(64)   ip详情
    private String ipDetail;

    @Override
    public String toString() {
        return "SewageLog{" +
                "id=" + id +
                ", time=" + time +
                ", log='" + log + '\'' +
                ", ip='" + ip + '\'' +
                ", ipDetail='" + ipDetail + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpDetail() {
        return ipDetail;
    }

    public void setIpDetail(String ipDetail) {
        this.ipDetail = ipDetail;
    }
}
