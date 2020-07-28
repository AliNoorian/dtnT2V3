package com.dotin.dotintasktwo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank(message = "is required")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "is required")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "is required")
	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee employeeManager;

	@OneToMany(mappedBy = "employeeManager", cascade = CascadeType.ALL)
	private List<Employee> managerEmployeesList;

	@OneToMany(mappedBy = "senderEmployee", cascade = CascadeType.ALL)
	private List<Email> senderEmails;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "receiver",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn(name = "email_id"))
	private List<Email> receiverEmails;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Leave> leaves;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private CategoryElement employeeRole;
	

	
	public Employee() {
		
	}

	public Employee(@NotBlank(message = "is required") String firstName,
					@NotBlank(message = "is required") String lastName,
					@NotBlank(message = "is required") String email, Employee employeeManager,
					List<Employee> managerEmployeesList, List<Email> senderEmails,
					List<Email> receiverEmails, List<Leave> leaves, CategoryElement employeeRole) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeManager = employeeManager;
		this.managerEmployeesList = managerEmployeesList;
		this.senderEmails = senderEmails;
		this.receiverEmails = receiverEmails;
		this.leaves = leaves;
		this.employeeRole = employeeRole;
	}


	public Employee(int id, Employee employeeManager,
					List<Employee> managerEmployeesList,
					List<Email> senderEmails, List<Email> receiverEmails,
					List<Leave> leaves, CategoryElement employeeRole) {
		this.id = id;
		this.employeeManager = employeeManager;
		this.managerEmployeesList = managerEmployeesList;
		this.senderEmails = senderEmails;
		this.receiverEmails = receiverEmails;
		this.leaves = leaves;
		this.employeeRole = employeeRole;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", employeeManager=" + employeeManager +
				", managerEmployeesList=" + managerEmployeesList +
				", senderEmails=" + senderEmails +
				", receiverEmails=" + receiverEmails +
				", leaves=" + leaves +
				", employeeRole=" + employeeRole +
				'}';
	}
}











