package com.dotin.dotintasktwo.controller;

import java.util.List;

import com.dotin.dotintasktwo.model.Employee;
import com.dotin.dotintasktwo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final EmployeeService employeeService;

    public ManagerController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }



    @GetMapping("/list")
    public String listEmployees(Model theModel) {


        List<Employee> theEmployees = employeeService.getAllEmployees();


        theModel.addAttribute("employees", theEmployees);

        return "employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {


        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {


        Employee theEmployee = employeeService.getEmployee(theId);


        theModel.addAttribute("employee", theEmployee);


        return "employees";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        employeeService.addEmployee(theEmployee);

        return "redirect:employees";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {


        employeeService.removeEmployee(theId);

        return "redirect:employees";

    }



}


















