package com.zhss.boot.server;

import com.zhss.boot.dao.UserDao;
import com.zhss.boot.domain.User;
import com.zhss.boot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    /**
     * 测试用例：获取用户信息
     */
    @Test
    public void testListUsers(){
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        List<User> users = new ArrayList<>();
        users.add(user);

        //对userDao进行mock逻辑设置
        when(userDao.listUser()).thenReturn(users);

        List<User> resultUsers = userService.listUser();

        assertEquals(users,resultUsers);
    }

    /**
     * 测试用例：根据id获取用户信息
     */
    @Test
    public void testGetUserById(){
        Long userId = 1L;
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        user.setId(userId);

        when(userDao.getUserById(userId)).thenReturn(user);

        User resultUser = userService.getUserById(userId);

        assertEquals(user,resultUser);
    }

    /**
     * 测试用例：新增用户
     */
    @Test
    public void testSaveUser(){
        Long userId = 1L;
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        user.setId(userId);

        when(userDao.saveUser(user)).thenReturn(userId);

        Long resultUserId = userService.saveUser(user);
        assertEquals(userId,resultUserId);
    }

    /**
     * 测试用例：更新用户
     */
    @Test
    public void testUpdateUser(){
        Long userId = 1L;
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        user.setId(userId);
        when(userDao.updateUser(user)).thenReturn(true);

        Boolean updateResult = userService.updateUser(user);
        assertTrue(updateResult);
    }

    /**
     * 删除用户
     */
    @Test
    public void testRemoveUser(){
        Long userId = 1L;
        when(userDao.removeUser(userId)).thenReturn(true);

        Boolean removeResult = userService.removeUser(userId);
        assertTrue(removeResult);
    }

}
