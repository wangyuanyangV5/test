package com.zhss.boot.dao;

import com.zhss.boot.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户信息
     * @return 用户信息
     */
    List<User> listUser();

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(Long id);

    /**
     * 新增用户信息
     * @param user 用户信息
     */
    Long saveUser(User user);

    /**
     * 更新用户信息
     * @param user 用户信息
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     */
    boolean  removeUser(Long id);

}
