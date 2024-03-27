package com.oracle.erpProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.erpProject.service.mk.MK_Service_interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class mkcontroller {

	private MK_Service_interface mk_Service_interface;
	
	@GetMapping("/mk")
	public String mkPage() {
		System.out.println("MKController Start...");
		return "mk/mk";
	}
}
