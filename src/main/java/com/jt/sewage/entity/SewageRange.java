package com.jt.sewage.entity;

public class SewageRange {
    //id      int(11)        (NULL)              NO      PRI     (NULL)   auto_increment  select,insert,update,references
    private Integer id;
    //name    varchar(16)    utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references  名称
    private String name;
    //min     decimal(20,6)  (NULL)              YES             (NULL)                   select,insert,update,references  最小
    private Double min;
    //max     decimal(20,6)  (NULL)              YES             (NULL)                   select,insert,update,references  最大
    private Double max;

    @Override
    public String toString() {
        return "AnalysisRange{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", min=" + min +
                ", max=" + max +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}
