package com.jt.sewage.service.impl;

import com.jt.sewage.entity.*;
import com.jt.sewage.mapper.UserMapper;
import com.jt.sewage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Sewage> getData() {
        return userMapper.getData();
    }

    @Override
    public List<SewageRange> getRange() {
        return userMapper.getRange();
    }

    @Override
    public SewageUser finUserByAccount(String account) {
        return userMapper.finUserByAccount(account);
    }

    @Override
    public SewageWarning getLatestWarn() {
        return userMapper.getLatestWarn();
    }

    @Override
    public void addLastWarn(Sewage sewage) {
        userMapper.addLastWarn(sewage);
    }

    @Override
    public List<SewageEmail> getEmailList() {
        return userMapper.getEmailList();
    }

    @Override
    public List<SewageHistory> getHistoryAvg(String name, String date) {
        return userMapper.getHistoryAvg(name,date);
    }


}
