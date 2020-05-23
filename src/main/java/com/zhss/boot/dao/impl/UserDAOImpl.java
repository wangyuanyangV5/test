package com.zhss.boot.dao.impl;

import com.zhss.boot.dao.UserDao;
import com.zhss.boot.domain.User;
import com.zhss.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl  implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Long saveUser(User user) {
        userMapper.saveUser(user);
        return user.getId();
    }

    @Override
    public boolean updateUser(User user) {
        userMapper.updateUser(user);
        return true;
    }

    @Override
    public boolean removeUser(Long id) {
        userMapper.removeUser(id);
        return true;
    }
}
