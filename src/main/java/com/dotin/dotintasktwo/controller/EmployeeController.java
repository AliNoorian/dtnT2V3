package com.dotin.dotintasktwo.controller;

import com.dotin.dotintasktwo.model.Email;
import com.dotin.dotintasktwo.model.Employee;
import com.dotin.dotintasktwo.model.Leave;
import com.dotin.dotintasktwo.service.EmailService;
import com.dotin.dotintasktwo.service.EmployeeService;
import com.dotin.dotintasktwo.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value={"/employees"}, produces = "text/plain;charset=UTF-8")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private LeaveService leaveService;

    @GetMapping("")
    public String getAllEmployees(Model model) {

        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "employees";
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        List<Leave> leaveList = leaveService.getAllLeaves();
        List<Email> emailList = emailService.getAllEmails();


        model.addAttribute("leaves", leaveList);
        model.addAttribute("emails", emailList);
        model.addAttribute("employee", employee);


        return "employees";
    }

    @GetMapping("{id}/history")
    public String getEmployeeHistory(@PathVariable Long id, Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employee", employeeService.getEmployee(id));
        model.addAttribute("employees", employees);

        return "/history";
    }


}
