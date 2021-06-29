package com.springboottest.demo.controller;

import com.springboottest.demo.entity.User;
import com.springboottest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

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
        return userService.findAll();
    }
}
