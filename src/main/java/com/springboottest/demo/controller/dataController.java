package com.springboottest.demo.controller;

import com.springboottest.demo.entity.User;
import com.springboottest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class dataController {

    @Autowired
    private UserService userService;

    /**
     * 动物对象 json
     *
     * @return
     */
    @RequestMapping("/abc")
    public Animal getName() {
        return new Animal("dog", 5);
    }

    /**
     * user 数据库对象 json
     *
     * @return
     */
    @RequestMapping("/user.json")
    public List<User> getUser() {
        System.out.println("查询用户信息");
        return userService.findAll();
    }


    @RequestMapping(path = "/insert")
    public boolean insert(int id, String name, int age, String email) {
        System.out.println("微信小程序调用接口 用户名: id: " + id + " name: " + name + " age: " + age + " email: " + email);
        //User user=new User(id, name, age, email)
        int addUser = userService.addUser(id, name, age, email);
        if (addUser == 1) {
            return true;
        }
        return false;
    }

}
