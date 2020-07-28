package com.dotin.dotintasktwo.controller;


import com.dotin.dotintasktwo.entity.Email;
import com.dotin.dotintasktwo.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @GetMapping("/list")
    public String listEmails(Model theModel) {


        List<Email> emails = emailService.findAll();


        theModel.addAttribute("emails", emails);

        return "/emails/list-email";
    }


}


















