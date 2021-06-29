package com.springboottest.demo.service;

import com.springboottest.demo.entity.User;
import com.springboottest.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper1;

    public List<User> findAll() {
        return userMapper1.findAll();
    }
}

