package com.demo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: IndexController
 * @Author Jessie
 * @Date 2021/8/15
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        //int i = 2/0;
        return "index";
    }
}
