package com.zhss.boot.web;

import com.zhss.boot.domain.User;
import com.zhss.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> listUser(){
        return userService.listUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") Long id){
        userService.removeUser(id);
    }

}
