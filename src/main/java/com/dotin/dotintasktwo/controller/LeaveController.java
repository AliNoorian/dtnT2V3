package com.dotin.dotintasktwo.controller;


import com.dotin.dotintasktwo.entity.Leave;
import com.dotin.dotintasktwo.service.LeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/email")
public class LeaveController {

	private final LeaveService leaveService;

	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
	


	@GetMapping("/list")
	public String listLeaves(Model theModel) {
		

		List<Leave> leaves = leaveService.findAll();
		

		theModel.addAttribute("leaves", leaves);
		
		return "/leaves/list-leaves";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		

		Leave leave = new Leave();
		
		theModel.addAttribute("leave", leave);
		
		return "/leaves/leave-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("leaveId") int theId,
									Model theModel) {
		

		Leave leave = leaveService.findById(theId);
		

		theModel.addAttribute("leave", leave);
		

		return "/leaves/leave-form";
	}
	


}


















