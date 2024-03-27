package com.oracle.erpProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class mkcontroller {

	
	@GetMapping("/mk")
	public String mkPage() {
		System.out.println("MKController Start...");
		return "mk/mk";
	}
}
