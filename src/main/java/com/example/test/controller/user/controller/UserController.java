package com.example.test.controller.user.controller;

import com.example.test.controller.user.entity.User;
import com.example.test.controller.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-15 16:10:20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne( @RequestBody Long id,@RequestBody Integer age) {
        System.out.println(age);
        User user =  userService.queryById(id);

        throw new RuntimeException("出错了");
    }

    @PostMapping("/select")
    public User select(@RequestBody User user){
        return user;
    }
}