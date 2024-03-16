package com.zhouzzz.ioc_02;

import com.alibaba.druid.filter.AutoLoad;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Resource(name="userServiceImpl")
    //@Autowired+@Qualifier("userServiceImpl")
    private UserService userService;
    public  void show(){
        String show = userService.show();
        System.out.println(show);
    }
}
