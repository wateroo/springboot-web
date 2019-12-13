package com.watero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController {
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("success")
    public String success(Model model) {
        model.addAttribute("name", "th:text=\"${name}\"");
        return "success";
    }

//    @RequestMapping(value = {"/", "index.html"})
//    public String login() {
//        return "login";
//    }
}
