package com.dotin.dotintasktwo.service;

import com.dotin.dotintasktwo.model.Email;
import com.dotin.dotintasktwo.model.Leave;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmailService {

    List<Email> getAllEmails();

    Leave getEmail(long id);

    void addEmail(Leave leave);

}


