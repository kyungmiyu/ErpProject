package com.oracle.erpProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KMController {

	/* 공통 화면 */
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
	
	/* 관리자 페이지 */
	// 관리자페이지 화면
	@GetMapping(value="adminMain")
	public String adminPage() {
		return "km/adminMain";
	}
	
	// 사원 등록
	@GetMapping(value="/adminRegisterForm")
	public String adminRegisteForm() {
		return "km/adminRegisterForm";
	}
	
	// 사원 리스트 조회
	// 검색탭, select box 추가, 페이징
	@GetMapping(value="/adminList")
	public String adminList() {
		return "km/adminList";
	}
	
 	// 메인 페이지
	// 구성
	
}
