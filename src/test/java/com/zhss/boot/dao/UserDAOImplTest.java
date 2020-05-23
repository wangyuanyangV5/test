package com.zhss.boot.dao;


import com.zhss.boot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UserDAOImplTest {
    @Autowired
    private UserDao userDao;

    /**
     * 测试用例：查询所有的用户信息
     */
    @Test
    public void testListUsers(){
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        List<User> users = new ArrayList<User>();
        users.add(user);
        List<User> resultUsers = userDao.listUser();

        assertEquals(users.size(),resultUsers.size());
    }

    /**
     * 测试用例：新增用户
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        userDao.saveUser(user);
        Long userId = user.getId();
        assertThat(userId,is(greaterThan(0L)));
    }

    /**
     * 测试用例：根据id查询用户信息
     */
    @Test
    public void testGetUserById(){
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        userDao.saveUser(user);
        Long userId = user.getId();
        User resultUser = userDao.getUserById(userId);
        assertEquals(user.toString(),resultUser.toString());
    }

    /**
     * 测试用例：修改用户信息
     */
    @Test
    public void testUpdateUser(){
        Integer oldAge = 20;
        Integer newAge = 21;

        User user = new User();
        user.setName("测试用户");
        user.setAge(oldAge);
        userDao.saveUser(user);

        user.setAge(newAge);
        userDao.updateUser(user);

        User resultUser = userDao.getUserById(user.getId());

        assertEquals(newAge,resultUser.getAge());
    }

    /**
     * 测试用例：删除用户
     */
    @Test
    public void testRemoveUser(){
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        userDao.saveUser(user);
        userDao.removeUser(user.getId());
        User resultUser = userDao.getUserById(user.getId());
        assertTrue(Objects.isNull(resultUser));
    }
}
