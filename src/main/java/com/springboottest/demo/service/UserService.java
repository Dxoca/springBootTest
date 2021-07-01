package com.springboottest.demo.service;

import com.springboottest.demo.entity.User;
import com.springboottest.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * bug的话
     * Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.springboottest.demo.mapper.UserMapper.findAll] with root cause
     * target mapper里 手动 添加 UserMapper.xml 即可
     * @return
     */
    @Select("select * from user")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 直接对应 String name int id int age 直接对应post
     * @return
     */

//    @RequestMapping("/insert")
    public int addUser(int id, String name, int age, String email)
    {
        return userMapper.insert(id,name,age,email);
    }
}

