package com.watero.app.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.watero.app.entity.User;
import com.watero.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public String GetUser(@PathVariable Long id,Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/add";
    }

    /**
     * 获取用户列表
     * @param start
     * @param size
     * @param user
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String list(@RequestParam(value = "start", defaultValue = "0") int start,
                       @RequestParam(value = "size", defaultValue = "10") int size,
                       User user, Model model) {
        PageHelper.startPage(start, size);
        List<User> userList = userService.findAll(user);
        PageInfo<User> page = new PageInfo<>(userList);
        model.addAttribute("pageInfo", page);
        //classpath:/templates/user/list.html
        System.out.println(page.toString());
        return "user/list";
    }

    /**
     * 跳转到新增页面
     * @param user
     * @return
     */
    @GetMapping("/user")
    public String addUser() {
        return "user/add";
    }

    @PostMapping("/user")
    public String save(User user) {
        userService.insert(user);
        System.out.println(user);
        return "redirect:/users";
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping("/user")
    public String put(User user) {
        userService.updateById(user);
        System.out.println(user);
        return "redirect:/users";
    }


    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}

