package com.inspur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/index")
    public String toIndex() {
        return "/ythzs/index";
    }


    @RequestMapping("/{page}")
    public String testController(@PathVariable String page) {
        System.out.println(page+"===========");
        String pages = page.replace(".html","");
        return "/ythzs/" + pages;
    }

}
