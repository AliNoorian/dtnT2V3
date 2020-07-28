package com.dotin.dotintasktwo.service;

import com.dotin.dotintasktwo.dao.EmailRepository;
import com.dotin.dotintasktwo.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public Email findById(int Id) {
        Optional<Email> result = emailRepository.findById(Id);

        Email email;

        if (result.isPresent()) {
            email = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find email id - " + Id);
        }

        return email;
    }

    @Override
    public void save(Email email) {
        emailRepository.save(email);
    }

    @Override
    public void deleteById(int Id) {
        emailRepository.deleteById(Id);
    }
}
