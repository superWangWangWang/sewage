package com.jt.sewage.entity;

public class SewageEmail {
    //id      int(11)      (NULL)              NO      PRI     (NULL)   auto_increment  select,insert,update,references
    private Integer id;
    //email   varchar(32)  utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references  email
    private String email;
    //delete  int(1)       (NULL)              YES             0                        select,insert,update,references  0=正常1=删除
    private Integer delete;

    private String remarks;

    @Override
    public String toString() {
        return "AnalysisEmail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", delete=" + delete +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
