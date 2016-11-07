package com.sport.mvc.Controllers.smoll_fintess;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/start/")
public class StartController {
    //starts index
    @RequestMapping("/")
    public String ShowIndexStartPage() {
        return "index";
    }

    //returns choose registration form page
    @RequestMapping("/showChooseRegisterForm")
    public String showChooseForm(){
        return "chooseRegisterFormRegistry";
    }


}