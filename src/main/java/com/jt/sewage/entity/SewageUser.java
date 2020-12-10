package com.jt.sewage.entity;

public class SewageUser {

    //id       int(11)      (NULL)              NO      PRI     (NULL)   auto_increment  select,insert,update,references
    private Integer ig;
    //account  varchar(32)  utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references  账号
    private String account;
    //pwd      varchar(32)  utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references  密码
    private String pwd;
    //remarks  varchar(32)  utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references  备注
    private String remarks;
    //delete   int(1)       (NULL)              YES             0                        select,insert,update,references  0=不能登录，1=允许登录
    private Integer delete;

    @Override
    public String toString() {
        return "User{" +
                "ig=" + ig +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", remarks='" + remarks + '\'' +
                ", delete=" + delete +
                '}';
    }

    public Integer getIg() {
        return ig;
    }

    public void setIg(Integer ig) {
        this.ig = ig;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }
}
