package com.oracle.erpProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.erpProject.model.Employee;
import com.oracle.erpProject.service.lhs.LHS_Serivce_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LHSController {//
	
	private final LHS_Serivce_Interface lhs;
	
	@RequestMapping(value="lhs")
	public String lhsListEmp(Employee emp, Model model) {
		
		List<Employee> listEmp = lhs.getListEmp();
		
		model.addAttribute("listEmp", listEmp);
		
		return "lhs/listEmp";
	}
	
	// 테스트용 인덱스
	@RequestMapping(value="lhsIndex")
	public String lhsIndex(Employee emp, Model model) {
		
		Employee empData = lhs.getDataEmp(emp.getEmp_no());
		
		model.addAttribute("empData", empData);

		return "lhs/index";
	}
	

	
	

} // class
