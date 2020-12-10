package com.jt.sewage.service;

import com.jt.sewage.entity.*;

import java.util.List;

public interface UserService {
    List<Sewage> getData();
    List<SewageRange> getRange();
    SewageUser finUserByAccount(String account);
    SewageWarning getLatestWarn();
    void addLastWarn(Sewage sewage);
    List<SewageEmail> getEmailList();
    List<SewageHistory> getHistoryAvg(String name, String date);

}
