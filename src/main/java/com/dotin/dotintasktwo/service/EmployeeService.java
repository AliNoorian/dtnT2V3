package com.dotin.dotintasktwo.service;

import java.util.List;

import com.dotin.dotintasktwo.model.Employee;


public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployee(long id);

    void addEmployee(Employee employee);

    void removeEmployee(long id);

    List<Employee> searchBy(String theName);

}
