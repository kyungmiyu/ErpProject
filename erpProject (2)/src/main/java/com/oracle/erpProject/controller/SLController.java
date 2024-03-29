package com.oracle.erpProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.erpProject.service.slservice.SL_Service_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SLController {

	private final SL_Service_Interface slService;
	
	
	
	// 구매 페이지
	@GetMapping(value = "buying")
	public String buying() {
		
		return "sl/buying";
	}
	
	// 구매 등록 페이지
	
	
	// 구매 상세 페이지
	@GetMapping(value = "buyDetail")
	public String buyDetail() {
		return "sl/buyDetail";
	}
	
}
