package com.dotin.dotintasktwo.service;


import com.dotin.dotintasktwo.entity.Employee;
import com.dotin.dotintasktwo.entity.Leave;

import java.util.List;

public interface LeaveService {

     List<Leave> findAll();

     Leave findById(int Id);

     void save(Leave leave);

     void deleteById(int Id);


    List<Leave> searchBy(String theName);
}
