package com.springboottest.demo.controller;

import com.springboottest.demo.entity.User;
import com.springboottest.demo.service.UserService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    @GetMapping("/user")
    public List<User> getUser() {
        System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"查询所有用户信息");
        return userService.findAll();
    }

    /**
     * post类型  wechat
     * wx.request({
     * url: 'http://localhost:8081/insert',
     * method:'POST',
     * header:{'Content-Type':'application/json'},
     * data:{
     * // 'id': this.data.id, // 不用传递主键*************
     * 'name': this.data.name,
     * 'age': this.data.age,
     * 'email': this.data.email,
     * },
     *
     * @param user
     * @return 插入条数1 然后true
     */
    @PostMapping(path = "/insert")
    public boolean insert(@RequestBody User user) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" 微信小程序调用接口: " +user.toString());
        //User user=new User(id, name, age, email)
        int addUserResult = userService.addUser(user);
        if (addUserResult == 1) {
            return true;
        }
        return false;
    }

    @PostMapping(path = "/delete")
    public boolean delete(@RequestBody User user) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" 删除id"+user.getId());
        int deleteResult = userService.deleteUser(user);
        if (deleteResult == 1)
            return true;
        return false;
    }

}
