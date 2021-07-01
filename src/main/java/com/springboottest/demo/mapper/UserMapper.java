package com.springboottest.demo.mapper;

import com.springboottest.demo.entity.User;
import org.apache.ibatis.annotations.*;

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
     * 插入新的用户
     * sql语句字段加飘
     *
     * @param
     * @return
     */
    @Insert("insert into `user`(name,age,email) values(#{name},#{age} ,#{email})")
    int insert(User user);

    /**
     * 删除某用户，通过 id（key)
     * @param user
     * @return
     */
    @Delete("delete from `user`where id=#{id}")
    int delete(User user);

}
