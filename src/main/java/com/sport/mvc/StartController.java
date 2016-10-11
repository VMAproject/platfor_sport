package com.sport.mvc;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/")
    public String ShowIndexStartPage() {
        return "index";
    }


    @RequestMapping("/showChooseRegisterForm")
    public String showChooseForm(){
        return "chooseRegisterFormRegistry";
    }


}