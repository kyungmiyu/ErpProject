package com.oracle.erpProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
// 수정 테스트 새잎 
	@GetMapping("/")
	public String indexPage() {///skdfjsdkjf
		System.out.println("MainController Start...");
		return "index";
	}
	
}
