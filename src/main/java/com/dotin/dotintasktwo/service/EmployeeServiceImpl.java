package com.dotin.dotintasktwo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotin.dotintasktwo.repository.EmployeeRepository;
import com.dotin.dotintasktwo.model.Employee;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee;

		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}

		return theEmployee;
	}

	@Override
	public void addEmployee(Employee Employee) {
		employeeRepository.save(Employee);
	}

	@Override
	public void removeEmployee(long id) {
		employeeRepository.deleteById(id);
	}



}







