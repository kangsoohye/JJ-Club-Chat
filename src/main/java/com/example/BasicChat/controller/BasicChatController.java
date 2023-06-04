package com.example.BasicChat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class BasicChatController {
    @RequestMapping("mychatt")
    public ModelAndView chatt() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chatting");
        return mv;
    }
}
