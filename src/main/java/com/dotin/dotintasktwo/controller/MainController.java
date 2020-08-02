package com.dotin.dotintasktwo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @GetMapping(value = {"/"}, produces = "text/plain;charset=UTF-8")
    public String index(Model model) {

        return "index";
    }

}
