package com.jt.sewage.entity;

public class SewageHistory {
    private Double avg;
    private String time;

    @Override
    public String toString() {
        return "History{" +
                "avg=" + avg +
                ", time='" + time + '\'' +
                '}';
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
