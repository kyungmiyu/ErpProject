package com.oracle.erpProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.erpProject.domain.Employee;
import com.oracle.erpProject.service.kmservice.KM_DepartmentServiceImpl;
import com.oracle.erpProject.service.kmservice.KM_EmployeeServiceImpl;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KMController {
	
	@Autowired
	private KM_EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private KM_DepartmentServiceImpl departmentServiceImpl;
	
	@Autowired
	private final JavaMailSender mailSender;
	
	/* 공통 화면 */
	// 로그인
	@GetMapping(value = "/loginForm")
	public String loginForm() {
		System.out.println("KMController loginPage start...*");
		return "km/loginForm";
	}
	
	// 로그인
	@PostMapping(value="/loginProc")
	public String loginProc(HttpServletRequest request, @RequestParam("empNo") String empNo, @RequestParam("empPassword") String empPassword, Model model) {
		System.out.println("KMController loginPage start...*");
		HttpSession session = request.getSession();
		Employee employee = employeeServiceImpl.findByEmpNo(Integer.parseInt(empNo));
		if (employee !=null && employee.getEmpPassword().equals(empPassword)) {
			session.setAttribute("empNo", empNo);
			session.setAttribute("empRole", employee.getEmpRole());
			return "main";
		} else {
			model.addAttribute("mode", "error");
			return "redirect:/loginForm";
		}
	}
	
	// 아이디 찾기
	@GetMapping(value = "/findAccountForm")
	public String findEmployeeForm(Model model) {
		model.addAttribute("mode", "findAccount");
		return "km/findAccountForm";
	}
	
	@RequestMapping(value="/findAccountProc")
	private String findAccountProc(Model model, @RequestParam("empEmail") String empEmail, @RequestParam("empNo") String empNo) {
		System.out.println("KMController findAccountProc start---*");
		Employee employee = employeeServiceImpl.findByEmpNo(Integer.parseInt(empNo));
		
		if (employee != null && employee.getEmpEmail().equals(empEmail)) {
			
			String tomail = empEmail;
			String setfrom = "yk.km0304@gmail.com";
			String title = "erp 관리자입니다 비밀번호 변경 안내";
			
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true , "UTF-8");
				messageHelper.setFrom(setfrom);
				messageHelper.setTo(tomail);
				messageHelper.setSubject(title);
				
				String tempPassword = (int) (Math.random() * 999999) + 1 + "";
				messageHelper.setText("안녕하세요" + employee.getEmpName() +" 님의 임시 비밀번호입니다 : " + tempPassword);
				mailSender.send(message);
				
				employee.setEmpPassword(tempPassword);
				employeeServiceImpl.updateEmployee(employee);
				model.addAttribute("mode", "check");
				System.out.println("KMController findAccountProc mode : check");
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("mode", "none");
				System.out.println("KMController findAccountProc mode : none");
			}
		}
		return "km/findAccountForm";
	}
	
	@PostMapping(value = "/verifyCode")
	private String verifyCode(@RequestParam("code") int code, @RequestParam("empNo") String empNo, Model model) {
		Employee employee = employeeServiceImpl.findByEmpNo(Integer.parseInt(empNo));
		if(employee != null && employee.getEmpPassword().equals(String.valueOf(code))) {
			return "km/loginForm";
		}
		model.addAttribute("mode", "findAccount");
		return "km/findAccountForm";
	}
	
	// 마이페이지 화면
	@GetMapping(value = "/myPageForm")
	public String myPageForm(@RequestParam("empNo") String empNo, Model model) {
		// empNo를 제대로 받아오기
		// null 체크
		return "km/myPageForm";
	}
	
	// 마이페이지 사원 정보 수정
	@PostMapping(value="/myPageEditProc")
	public String myPageEditProc(Model model, @RequestParam("empNo") String empNo, Employee employee) {
		model.addAttribute("mode", "edit");
		model.addAttribute("employee", employeeServiceImpl.getEmployee(Integer.parseInt(empNo)));
		employeeServiceImpl.updateEmployee(employee);
		return "km/myPageForm";
	}
		
	/* 관리자 페이지 */
	// 관리자페이지 화면
	@GetMapping(value = "adminHome")
	public String adminHome() {
		return "km/adminHome";
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
			@RequestParam(required = false, defaultValue = "1", value ="pageNo") int pageNo) {
		//pageNo = pageNo == null ? "1" : pageNo;
		//int pageNum = Integer.parseInt(pageNo);
		//--pageNum;
		//int startRowNum = (Integer.parseInt(pageNo) - 1) * 10; // 0 ~ 10 ~ 20 해당 페이지의 시작 로우번호
		Pageable paging = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "empNo");
		//Page<Employee> listPage = employeeServiceImpl.listPage(paging);
		Page<Employee> listEmployee = employeeServiceImpl.listPage(paging);
		model.addAttribute("listEmployee", listEmployee.getContent()); //
		model.addAttribute("page",listEmployee);
		model.addAttribute("pageNo", pageNo);
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
	
	
/*
	// 부서
	@RequestMapping(value="departmentListProc")
	public String departmentListProc(Model model) {
		List<Department> listDepartment = departmentServiceImpl.listDepartment();
		model.addAttribute("listDepartment", listDepartment);
		return "km/departmentList";
*/
	
	
	// 세션
	
	
	
	
}