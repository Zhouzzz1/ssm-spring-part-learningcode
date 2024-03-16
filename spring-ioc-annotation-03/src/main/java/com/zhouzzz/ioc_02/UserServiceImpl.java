package com.zhouzzz.ioc_02;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService{
    @Override
    public String show() {
        return "userserviceImpl show";
    }
}
