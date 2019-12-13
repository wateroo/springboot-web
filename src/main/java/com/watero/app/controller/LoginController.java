package com.watero.app.controller;

import com.watero.app.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    final UserMapper userMapper;

    @Autowired
    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/user/login")
    public String login(@RequestParam("userName") String userName
            , @RequestParam("passWord") String passWord, HttpServletRequest request, Map<String,Object> map) {
        log.info("登录用户是:"+userName+"----密码是:"+passWord);
        if ("123".equals(passWord)) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            return "redirect:/main.html";
        } else {
            map.put("msg", "密码错误！");
            return "login";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request) {
            HttpSession session = request.getSession();
            session.invalidate();
            return "redirect:/";
    }
}
