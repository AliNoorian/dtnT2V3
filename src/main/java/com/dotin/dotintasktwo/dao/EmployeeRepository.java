package com.dotin.dotintasktwo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotin.dotintasktwo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    // add a method to sort by last name
     List<Employee> findAllByOrderByLastNameAsc();

    // search by name or family
     List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
