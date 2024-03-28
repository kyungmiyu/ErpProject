package com.oracle.erpProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KMController {

	// 로그인
	@GetMapping(value="loginForm")
	public String loginPage() {
		System.out.println("KMController loginPage start...*");
		return "km/loginForm";
	}
	
	// 아이디 찾기
	@GetMapping(value="/findAccountForm")
	public String findInfo() {
		System.out.println("KMController findId start...*");
		return "km/findAccountForm";
	}
	
	// 마이페이지
	@GetMapping(value="/myPage")
	public String myPage() {
		return "km/myPage";
	}
	
	
	// 관리자페이지 화면
	@GetMapping(value="adminMain")
	public String adminPage() {
		return "km/adminMain";
	}
	
	// 사이드바, 사원 등록, 담당자 권한
	
	
 	// 메인 페이지
	
}
