package com.springboottest.demo.mapper;

import com.springboottest.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 建立Mapper接口定义要操作的数据库动作
 */
@Mapper
public interface UserMapper {
    /**
     * 查找所有的User
     * @return
     */
    //@Select("select * from user")
    List<User> findAll();

}
