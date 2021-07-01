package com.springboottest.demo.mapper;

import com.springboottest.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 建立Mapper接口定义要操作的数据库动作
 */
@Mapper
public interface UserMapper {
    /**
     * 查找所有的User
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     *
     * sql语句字段加飘
     * @param
     * @return
     */
    @Insert("insert into `user`(name,age,email) values(#{name},#{age} ,#{email})")
    int insert(User user);
}
