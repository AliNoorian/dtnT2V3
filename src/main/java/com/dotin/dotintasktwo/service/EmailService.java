package com.dotin.dotintasktwo.service;


import com.dotin.dotintasktwo.entity.Email;

import java.util.List;

public interface EmailService {

     List<Email> findAll();

     Email findById(int Id);

     void save(Email email);

     void deleteById(int Id);
}
