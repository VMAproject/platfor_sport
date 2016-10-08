package com.sport.mvc;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {
    //starts index
    @RequestMapping("/")
    public String ShowIndexStartPage() {
        return "index";
    }

    //returns chooseregistration form page
    @RequestMapping("/showChooseRegisterForm")
    public String showChooseForm(){
        return "chooseRegisterFormRegistry";
    }


}