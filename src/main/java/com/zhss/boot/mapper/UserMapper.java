package com.zhss.boot.mapper;

import com.zhss.boot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * from user")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })
    List<User> listUsers();


    @Select("SELECT * from user where id = #{id}")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })
    User getUserById(@Param("id") Long id);

    @Insert("INSERT INTO user(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveUser(User user);

    @Update("UPDATE user SET name=#{name},age=#{age} where id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user where id = #{id}")
    void removeUser(@Param("id") Long id);
}
