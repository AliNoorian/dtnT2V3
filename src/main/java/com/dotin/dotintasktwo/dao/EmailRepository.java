package com.dotin.dotintasktwo.dao;


import com.dotin.dotintasktwo.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {

}
