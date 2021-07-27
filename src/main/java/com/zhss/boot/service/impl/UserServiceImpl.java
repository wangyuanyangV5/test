package com.zhss.boot.service.impl;

import com.zhss.boot.dao.UserDao;
import com.zhss.boot.domain.User;
import com.zhss.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    //a修改
    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public Long saveUser(User user) {
      return userDao.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean removeUser(Long id) {
       return userDao.removeUser(id);
    }
}
