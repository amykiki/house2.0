package com.april.house.cloud.api.gateway.service;

import com.april.house.cloud.api.gateway.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String getUserName(Long id) {
        return userDao.getUserName(id);
    }
}
