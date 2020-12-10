package com.jt.sewage.entity;

/**
 * 数据库的监控数据表实体类
 */
public class Sewage {
    //id      int(11)
    private Integer id;
    //time    varchar(20)   时间
    private String time;
    //ph      varchar(20)   PH值
    private String ph;
    //ss      varchar(20)   悬浮物
    private String ss;
    //cod     varchar(20)   COD
    private String cod;
    //nh      varchar(20)   氨氮
    private String nh;
    //cu      varchar(20)   铜
    private String cu;
    //ni      varchar(20)   镍
    private String ni;
    //fr      varchar(20)   流量
    private String fr;

    @Override
    public String toString() {
        return "Analysis{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", ph='" + ph + '\'' +
                ", ss='" + ss + '\'' +
                ", cod='" + cod + '\'' +
                ", nh='" + nh + '\'' +
                ", cu='" + cu + '\'' +
                ", ni='" + ni + '\'' +
                ", fr='" + fr + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNh() {
        return nh;
    }

    public void setNh(String nh) {
        this.nh = nh;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(String ni) {
        this.ni = ni;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }
}
