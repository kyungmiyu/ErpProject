package com.oracle.erpProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.erpProject.domain.Employee;
import com.oracle.erpProject.service.kmservice.KM_EmployeeServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KMController {
	
	@Autowired
	private KM_EmployeeServiceImpl employeeServiceImpl;

	/* test */
	@GetMapping(value = "stest")
	public String testPage() {
		return "km/stest";
	}
	
	
	
	/* 공통 화면 */
	// 로그인
	@GetMapping(value = "loginForm")
	public String loginPage() {
		System.out.println("KMController loginPage start...*");
		return "km/loginForm";
	}
	
	// 아이디 찾기
	@GetMapping(value = "/findAccountForm")
	public String findInfo() {
		System.out.println("KMController findId start...*");
		return "km/findAccountForm";
	}
	
	// 마이페이지
	@GetMapping(value = "/myPage")
	public String myPage() {
		return "km/myPage";
	}
	
	
	
	/* 관리자 페이지 */
	// 관리자페이지 화면
	@GetMapping(value = "adminMain")
	public String adminMain() {
		return "km/adminMain";
	}
	
	// 사원 등록 화면
	@GetMapping(value = "/employeeRegistForm")
	public String employeeRegistForm(Model model) {
		model.addAttribute("mode", "regist");
		return "km/employeeRegistForm";
	}
	
	// 사원 등록
	@PostMapping(value = "/employeeRegistProc")
	public String employeeRegistProc(Model model, Employee employee) {
		employeeServiceImpl.registEmployee(employee);
		return "km/employeeList";
	}
	
	// 사원 리스트 조회
	@RequestMapping(value = "/listEmployeeProc")
	public String listEmployeeProc(
			Model model, 
			@RequestParam(required = false, value ="currPageNum") String currPageNum) {
		currPageNum = currPageNum == null ? "1" : currPageNum; 
		int startRowNum = (Integer.parseInt(currPageNum) - 1) * 10 + 1;
		Pageable paging = PageRequest.of(startRowNum, 10, Sort.Direction.DESC, "empNo");
		model.addAttribute("listEmployee", employeeServiceImpl.listEmployee(paging));
		return "km/employeeList";
	}
	

	//@RequestParam(value = "searchType", required = false, defaultValue = "A") String searchType,
	//@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue)

	
	// 사원 조회 및 수정 폼
	@GetMapping(value = "/employeeEditForm")
	public String employeeEditForm(Model model, @RequestParam("empNo") String empNo) {
		model.addAttribute("mode", "edit");
		model.addAttribute("employee", employeeServiceImpl.getEmployee(Integer.parseInt(empNo)));
		return "km/employeeRegistForm";
	}
	
	// 사원 조회 및 수정
	@PostMapping(value = "/employeeEditProc")
	public String employeeEditProc(Model model, @RequestParam("empNo") String empNo, Employee employee) {
		model.addAttribute("mode", "edit");
		model.addAttribute("employee", employeeServiceImpl.getEmployee(Integer.parseInt(empNo)));
		employee.setEmpNo(Integer.parseInt(empNo));
		employeeServiceImpl.updateEmployee(employee);
		return "km/employeeRegistForm";
	}
		

	/* 세션 유저 정보 */
}