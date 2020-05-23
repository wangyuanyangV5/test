package com.zhss.boot.web;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhss.boot.domain.User;
import com.zhss.boot.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    /**
     * 测试用例：获取用户
     */
    @Test
    public void testListUsers(){
        try {
            List<User> users = new ArrayList<>();
            User user = new User();
            user.setName("测试用户");
            user.setAge(20);
            users.add(user);

            when(userService.listUser()).thenReturn(users);
            mockMvc.perform(get("/user/")).andExpect(content().json(JSONArray.toJSONString(users)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 测试用例：根据用户id查询一个用户
     */
    @Test
    public void testGetUserById(){
        try{
            Long userId = 1L;
            User user = new User();
            user.setName("测试用户");
            user.setAge(20);
            user.setId(userId);

            when(userService.getUserById(userId)).thenReturn(user);
            mockMvc.perform(get("/user/{id}",userId)).
                    andExpect(content().json(JSONObject.toJSONString(user)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 测试用例：新增用户
     */
    @Test
    public void testSaveUser(){
        try{
            Long userId = 1L;
            User user = new User();
            user.setName("测试用户");
            user.setAge(20);
            user.setId(userId);

            when(userService.saveUser(user)).thenReturn(userId);
            mockMvc.perform(post("/user/").content(JSONObject.toJSONString(user))).
                    andExpect(content().json(JSONObject.toJSONString(user)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 测试用例：更新用户信息
     */
    @Test
    public void testUpdateUser(){
        Long userId = 1L;
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        user.setId(userId);

        when(userService.updateUser(user)).thenReturn(true);

        try{
            mockMvc.perform(put("/user/{id}",userId).
                    content(JSONObject.toJSONString(user))).andExpect(content().string("success"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveUser(){
        Long userId = 1L;

        when(userService.removeUser(userId)).thenReturn(true);

        try{
            mockMvc.perform(delete("/user/{id}",userId)).andExpect(content().string("success"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
